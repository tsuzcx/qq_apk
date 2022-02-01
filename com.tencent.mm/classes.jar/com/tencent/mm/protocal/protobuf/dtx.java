package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtx
  extends com.tencent.mm.bx.a
{
  public String Krl;
  public String YYZ;
  public int aaZu;
  public int aaZv;
  public eod aaZw;
  public String desc;
  public String icon;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91555);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.Krl != null) {
        paramVarArgs.g(3, this.Krl);
      }
      paramVarArgs.bS(4, this.aaZu);
      paramVarArgs.bS(5, this.aaZv);
      if (this.YYZ != null) {
        paramVarArgs.g(6, this.YYZ);
      }
      if (this.icon != null) {
        paramVarArgs.g(7, this.icon);
      }
      if (this.aaZw != null)
      {
        paramVarArgs.qD(8, this.aaZw.computeSize());
        this.aaZw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label676;
      }
    }
    label676:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.Krl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Krl);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aaZu) + i.a.a.b.b.a.cJ(5, this.aaZv);
      paramInt = i;
      if (this.YYZ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YYZ);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.icon);
      }
      paramInt = i;
      if (this.aaZw != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaZw.computeSize());
      }
      AppMethodBeat.o(91555);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dtx localdtx = (dtx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91555);
          return -1;
        case 1: 
          localdtx.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 2: 
          localdtx.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 3: 
          localdtx.Krl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 4: 
          localdtx.aaZu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91555);
          return 0;
        case 5: 
          localdtx.aaZv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91555);
          return 0;
        case 6: 
          localdtx.YYZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 7: 
          localdtx.icon = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91555);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eod localeod = new eod();
          if ((localObject != null) && (localObject.length > 0)) {
            localeod.parseFrom((byte[])localObject);
          }
          localdtx.aaZw = localeod;
          paramInt += 1;
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      AppMethodBeat.o(91555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtx
 * JD-Core Version:    0.7.0.1
 */