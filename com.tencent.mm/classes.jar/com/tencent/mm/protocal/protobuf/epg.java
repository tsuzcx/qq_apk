package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epg
  extends com.tencent.mm.bx.a
{
  public int abts;
  public LinkedList<eph> abtt;
  public String abtu;
  public String abtv;
  public String abtw;
  public int icon_height;
  public String icon_url;
  public int icon_width;
  public String igN;
  
  public epg()
  {
    AppMethodBeat.i(259316);
    this.abtt = new LinkedList();
    AppMethodBeat.o(259316);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259320);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abts);
      paramVarArgs.e(2, 8, this.abtt);
      if (this.igN != null) {
        paramVarArgs.g(3, this.igN);
      }
      if (this.abtu != null) {
        paramVarArgs.g(4, this.abtu);
      }
      if (this.abtv != null) {
        paramVarArgs.g(5, this.abtv);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(6, this.icon_url);
      }
      paramVarArgs.bS(7, this.icon_width);
      paramVarArgs.bS(8, this.icon_height);
      if (this.abtw != null) {
        paramVarArgs.g(9, this.abtw);
      }
      AppMethodBeat.o(259320);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abts) + 0 + i.a.a.a.c(2, 8, this.abtt);
      paramInt = i;
      if (this.igN != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.igN);
      }
      i = paramInt;
      if (this.abtu != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abtu);
      }
      paramInt = i;
      if (this.abtv != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abtv);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.icon_url);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.icon_width) + i.a.a.b.b.a.cJ(8, this.icon_height);
      paramInt = i;
      if (this.abtw != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abtw);
      }
      AppMethodBeat.o(259320);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abtt.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259320);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      epg localepg = (epg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259320);
        return -1;
      case 1: 
        localepg.abts = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259320);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eph localeph = new eph();
          if ((localObject != null) && (localObject.length > 0)) {
            localeph.parseFrom((byte[])localObject);
          }
          localepg.abtt.add(localeph);
          paramInt += 1;
        }
        AppMethodBeat.o(259320);
        return 0;
      case 3: 
        localepg.igN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259320);
        return 0;
      case 4: 
        localepg.abtu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259320);
        return 0;
      case 5: 
        localepg.abtv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259320);
        return 0;
      case 6: 
        localepg.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259320);
        return 0;
      case 7: 
        localepg.icon_width = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259320);
        return 0;
      case 8: 
        localepg.icon_height = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259320);
        return 0;
      }
      localepg.abtw = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(259320);
      return 0;
    }
    AppMethodBeat.o(259320);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epg
 * JD-Core Version:    0.7.0.1
 */