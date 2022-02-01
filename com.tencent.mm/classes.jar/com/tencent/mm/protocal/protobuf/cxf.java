package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cxf
  extends com.tencent.mm.bx.a
{
  public String Epo;
  public String Epp;
  public String Epq;
  public String Epr;
  public int htj;
  public int htk;
  public int htl;
  public int htm;
  public int opType;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Epo == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Epp == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Epq == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Epr == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.opType);
      paramVarArgs.aR(2, this.htm);
      paramVarArgs.aR(3, this.htj);
      paramVarArgs.aG(4, this.timeStamp);
      paramVarArgs.aR(5, this.htk);
      paramVarArgs.aR(6, this.htl);
      if (this.Epo != null) {
        paramVarArgs.d(7, this.Epo);
      }
      if (this.Epp != null) {
        paramVarArgs.d(8, this.Epp);
      }
      if (this.Epq != null) {
        paramVarArgs.d(9, this.Epq);
      }
      if (this.Epr != null) {
        paramVarArgs.d(10, this.Epr);
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.opType) + 0 + f.a.a.b.b.a.bA(2, this.htm) + f.a.a.b.b.a.bA(3, this.htj) + f.a.a.b.b.a.q(4, this.timeStamp) + f.a.a.b.b.a.bA(5, this.htk) + f.a.a.b.b.a.bA(6, this.htl);
      paramInt = i;
      if (this.Epo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Epo);
      }
      i = paramInt;
      if (this.Epp != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Epp);
      }
      paramInt = i;
      if (this.Epq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Epq);
      }
      i = paramInt;
      if (this.Epr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Epr);
      }
      AppMethodBeat.o(125841);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Epo == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Epp == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Epq == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Epr == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cxf localcxf = (cxf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125841);
        return -1;
      case 1: 
        localcxf.opType = locala.KhF.xS();
        AppMethodBeat.o(125841);
        return 0;
      case 2: 
        localcxf.htm = locala.KhF.xS();
        AppMethodBeat.o(125841);
        return 0;
      case 3: 
        localcxf.htj = locala.KhF.xS();
        AppMethodBeat.o(125841);
        return 0;
      case 4: 
        localcxf.timeStamp = locala.KhF.xT();
        AppMethodBeat.o(125841);
        return 0;
      case 5: 
        localcxf.htk = locala.KhF.xS();
        AppMethodBeat.o(125841);
        return 0;
      case 6: 
        localcxf.htl = locala.KhF.xS();
        AppMethodBeat.o(125841);
        return 0;
      case 7: 
        localcxf.Epo = locala.KhF.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 8: 
        localcxf.Epp = locala.KhF.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 9: 
        localcxf.Epq = locala.KhF.readString();
        AppMethodBeat.o(125841);
        return 0;
      }
      localcxf.Epr = locala.KhF.readString();
      AppMethodBeat.o(125841);
      return 0;
    }
    AppMethodBeat.o(125841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxf
 * JD-Core Version:    0.7.0.1
 */