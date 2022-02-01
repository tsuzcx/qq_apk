package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dis
  extends com.tencent.mm.bx.a
{
  public String Cxw;
  public String Dap;
  public String Ezd;
  public String ijR;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.Ezd == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.Ezd != null) {
        paramVarArgs.d(2, this.Ezd);
      }
      if (this.mBV != null) {
        paramVarArgs.d(3, this.mBV);
      }
      if (this.Dap != null) {
        paramVarArgs.d(4, this.Dap);
      }
      if (this.ijR != null) {
        paramVarArgs.d(5, this.ijR);
      }
      if (this.Cxw != null) {
        paramVarArgs.d(6, this.Cxw);
      }
      AppMethodBeat.o(117939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ezd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ezd);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mBV);
      }
      paramInt = i;
      if (this.Dap != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dap);
      }
      i = paramInt;
      if (this.ijR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ijR);
      }
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cxw);
      }
      AppMethodBeat.o(117939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mAQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        if (this.Ezd == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117939);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dis localdis = (dis)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117939);
          return -1;
        case 1: 
          localdis.mAQ = locala.KhF.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 2: 
          localdis.Ezd = locala.KhF.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 3: 
          localdis.mBV = locala.KhF.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 4: 
          localdis.Dap = locala.KhF.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 5: 
          localdis.ijR = locala.KhF.readString();
          AppMethodBeat.o(117939);
          return 0;
        }
        localdis.Cxw = locala.KhF.readString();
        AppMethodBeat.o(117939);
        return 0;
      }
      AppMethodBeat.o(117939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dis
 * JD-Core Version:    0.7.0.1
 */