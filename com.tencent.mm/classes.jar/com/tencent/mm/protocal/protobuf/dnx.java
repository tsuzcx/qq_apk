package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dnx
  extends com.tencent.mm.bx.a
{
  public int DBB;
  public int DCv;
  public int DCw;
  public int DCx;
  public long HBS;
  public int HBT;
  public long HBU;
  public String dDH;
  public int ePo;
  public String extInfo;
  public int inh;
  public long ioS;
  public String msgId;
  public String text;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153002);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.msgId != null) {
        paramVarArgs.d(1, this.msgId);
      }
      paramVarArgs.aS(2, this.DCv);
      paramVarArgs.aS(3, this.DCw);
      paramVarArgs.aY(4, this.ioS);
      paramVarArgs.aS(5, this.DBB);
      paramVarArgs.aS(6, this.type);
      if (this.text != null) {
        paramVarArgs.d(7, this.text);
      }
      if (this.dDH != null) {
        paramVarArgs.d(8, this.dDH);
      }
      paramVarArgs.aY(9, this.HBS);
      paramVarArgs.aS(10, this.DCx);
      paramVarArgs.aS(11, this.HBT);
      paramVarArgs.aY(12, this.HBU);
      paramVarArgs.aS(13, this.ePo);
      paramVarArgs.aS(14, this.inh);
      if (this.extInfo != null) {
        paramVarArgs.d(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.msgId == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.b.b.a.e(1, this.msgId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.DCv) + f.a.a.b.b.a.bz(3, this.DCw) + f.a.a.b.b.a.p(4, this.ioS) + f.a.a.b.b.a.bz(5, this.DBB) + f.a.a.b.b.a.bz(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.text);
      }
      i = paramInt;
      if (this.dDH != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dDH);
      }
      i = i + f.a.a.b.b.a.p(9, this.HBS) + f.a.a.b.b.a.bz(10, this.DCx) + f.a.a.b.b.a.bz(11, this.HBT) + f.a.a.b.b.a.p(12, this.HBU) + f.a.a.b.b.a.bz(13, this.ePo) + f.a.a.b.b.a.bz(14, this.inh);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153002);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnx localdnx = (dnx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153002);
          return -1;
        case 1: 
          localdnx.msgId = locala.NPN.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 2: 
          localdnx.DCv = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 3: 
          localdnx.DCw = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 4: 
          localdnx.ioS = locala.NPN.zd();
          AppMethodBeat.o(153002);
          return 0;
        case 5: 
          localdnx.DBB = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 6: 
          localdnx.type = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 7: 
          localdnx.text = locala.NPN.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 8: 
          localdnx.dDH = locala.NPN.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 9: 
          localdnx.HBS = locala.NPN.zd();
          AppMethodBeat.o(153002);
          return 0;
        case 10: 
          localdnx.DCx = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 11: 
          localdnx.HBT = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 12: 
          localdnx.HBU = locala.NPN.zd();
          AppMethodBeat.o(153002);
          return 0;
        case 13: 
          localdnx.ePo = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        case 14: 
          localdnx.inh = locala.NPN.zc();
          AppMethodBeat.o(153002);
          return 0;
        }
        localdnx.extInfo = locala.NPN.readString();
        AppMethodBeat.o(153002);
        return 0;
      }
      AppMethodBeat.o(153002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnx
 * JD-Core Version:    0.7.0.1
 */