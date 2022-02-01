package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bwc
  extends com.tencent.mm.bx.a
{
  public long ECY;
  public int aadB;
  public int aaed;
  public bwd aaee;
  public String akkR;
  public String icon_url;
  public int type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258731);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaed);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.bS(3, this.aadB);
      paramVarArgs.bv(4, this.ECY);
      if (this.aaee != null)
      {
        paramVarArgs.qD(5, this.aaee.computeSize());
        this.aaee.writeFields(paramVarArgs);
      }
      if (this.akkR != null) {
        paramVarArgs.g(6, this.akkR);
      }
      paramVarArgs.bS(7, this.type);
      if (this.icon_url != null) {
        paramVarArgs.g(8, this.icon_url);
      }
      AppMethodBeat.o(258731);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaed) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.aadB) + i.a.a.b.b.a.q(4, this.ECY);
      paramInt = i;
      if (this.aaee != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaee.computeSize());
      }
      i = paramInt;
      if (this.akkR != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.akkR);
      }
      i += i.a.a.b.b.a.cJ(7, this.type);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.icon_url);
      }
      AppMethodBeat.o(258731);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258731);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bwc localbwc = (bwc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258731);
        return -1;
      case 1: 
        localbwc.aaed = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258731);
        return 0;
      case 2: 
        localbwc.wording = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258731);
        return 0;
      case 3: 
        localbwc.aadB = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258731);
        return 0;
      case 4: 
        localbwc.ECY = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258731);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bwd localbwd = new bwd();
          if ((localObject != null) && (localObject.length > 0)) {
            localbwd.parseFrom((byte[])localObject);
          }
          localbwc.aaee = localbwd;
          paramInt += 1;
        }
        AppMethodBeat.o(258731);
        return 0;
      case 6: 
        localbwc.akkR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258731);
        return 0;
      case 7: 
        localbwc.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258731);
        return 0;
      }
      localbwc.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258731);
      return 0;
    }
    AppMethodBeat.o(258731);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwc
 * JD-Core Version:    0.7.0.1
 */