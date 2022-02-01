package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class emm
  extends com.tencent.mm.cd.a
{
  public String UoZ;
  public String Upa;
  public String Upb;
  public String Upc;
  public int mbo;
  public int mbp;
  public int mbq;
  public int opType;
  public int page;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UoZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Upa == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Upb == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Upc == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.opType);
      paramVarArgs.aY(2, this.page);
      paramVarArgs.aY(3, this.mbo);
      paramVarArgs.bm(4, this.timeStamp);
      paramVarArgs.aY(5, this.mbp);
      paramVarArgs.aY(6, this.mbq);
      if (this.UoZ != null) {
        paramVarArgs.f(7, this.UoZ);
      }
      if (this.Upa != null) {
        paramVarArgs.f(8, this.Upa);
      }
      if (this.Upb != null) {
        paramVarArgs.f(9, this.Upb);
      }
      if (this.Upc != null) {
        paramVarArgs.f(10, this.Upc);
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.opType) + 0 + g.a.a.b.b.a.bM(2, this.page) + g.a.a.b.b.a.bM(3, this.mbo) + g.a.a.b.b.a.p(4, this.timeStamp) + g.a.a.b.b.a.bM(5, this.mbp) + g.a.a.b.b.a.bM(6, this.mbq);
      paramInt = i;
      if (this.UoZ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UoZ);
      }
      i = paramInt;
      if (this.Upa != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Upa);
      }
      paramInt = i;
      if (this.Upb != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Upb);
      }
      i = paramInt;
      if (this.Upc != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Upc);
      }
      AppMethodBeat.o(125841);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.UoZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Upa == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Upb == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.Upc == null)
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
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      emm localemm = (emm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125841);
        return -1;
      case 1: 
        localemm.opType = locala.abFh.AK();
        AppMethodBeat.o(125841);
        return 0;
      case 2: 
        localemm.page = locala.abFh.AK();
        AppMethodBeat.o(125841);
        return 0;
      case 3: 
        localemm.mbo = locala.abFh.AK();
        AppMethodBeat.o(125841);
        return 0;
      case 4: 
        localemm.timeStamp = locala.abFh.AN();
        AppMethodBeat.o(125841);
        return 0;
      case 5: 
        localemm.mbp = locala.abFh.AK();
        AppMethodBeat.o(125841);
        return 0;
      case 6: 
        localemm.mbq = locala.abFh.AK();
        AppMethodBeat.o(125841);
        return 0;
      case 7: 
        localemm.UoZ = locala.abFh.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 8: 
        localemm.Upa = locala.abFh.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 9: 
        localemm.Upb = locala.abFh.readString();
        AppMethodBeat.o(125841);
        return 0;
      }
      localemm.Upc = locala.abFh.readString();
      AppMethodBeat.o(125841);
      return 0;
    }
    AppMethodBeat.o(125841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emm
 * JD-Core Version:    0.7.0.1
 */