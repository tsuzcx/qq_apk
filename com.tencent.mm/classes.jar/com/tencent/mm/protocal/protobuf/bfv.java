package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfv
  extends com.tencent.mm.bx.a
{
  public String DDA;
  public String DDB;
  public String DDC;
  public String DDw;
  public String DDx;
  public String DDy;
  public String DDz;
  public String gsg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DDw != null) {
        paramVarArgs.d(1, this.DDw);
      }
      if (this.DDx != null) {
        paramVarArgs.d(2, this.DDx);
      }
      if (this.gsg != null) {
        paramVarArgs.d(3, this.gsg);
      }
      if (this.DDy != null) {
        paramVarArgs.d(4, this.DDy);
      }
      if (this.DDz != null) {
        paramVarArgs.d(5, this.DDz);
      }
      if (this.DDA != null) {
        paramVarArgs.d(6, this.DDA);
      }
      if (this.DDB != null) {
        paramVarArgs.d(7, this.DDB);
      }
      if (this.DDC != null) {
        paramVarArgs.d(8, this.DDC);
      }
      AppMethodBeat.o(91521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DDw == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.DDw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DDx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DDx);
      }
      i = paramInt;
      if (this.gsg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsg);
      }
      paramInt = i;
      if (this.DDy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DDy);
      }
      i = paramInt;
      if (this.DDz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DDz);
      }
      paramInt = i;
      if (this.DDA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DDA);
      }
      i = paramInt;
      if (this.DDB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DDB);
      }
      paramInt = i;
      if (this.DDC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DDC);
      }
      AppMethodBeat.o(91521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfv localbfv = (bfv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91521);
          return -1;
        case 1: 
          localbfv.DDw = locala.KhF.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 2: 
          localbfv.DDx = locala.KhF.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 3: 
          localbfv.gsg = locala.KhF.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 4: 
          localbfv.DDy = locala.KhF.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 5: 
          localbfv.DDz = locala.KhF.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 6: 
          localbfv.DDA = locala.KhF.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 7: 
          localbfv.DDB = locala.KhF.readString();
          AppMethodBeat.o(91521);
          return 0;
        }
        localbfv.DDC = locala.KhF.readString();
        AppMethodBeat.o(91521);
        return 0;
      }
      AppMethodBeat.o(91521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfv
 * JD-Core Version:    0.7.0.1
 */