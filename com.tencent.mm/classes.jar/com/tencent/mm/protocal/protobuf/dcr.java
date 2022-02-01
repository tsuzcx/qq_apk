package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dcr
  extends com.tencent.mm.bw.a
{
  public String FMn;
  public String FMo;
  public String FMp;
  public String FMq;
  public int hTL;
  public int hTM;
  public int hTN;
  public int hTO;
  public int opType;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FMn == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.FMo == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.FMp == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.FMq == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.opType);
      paramVarArgs.aR(2, this.hTO);
      paramVarArgs.aR(3, this.hTL);
      paramVarArgs.aO(4, this.timeStamp);
      paramVarArgs.aR(5, this.hTM);
      paramVarArgs.aR(6, this.hTN);
      if (this.FMn != null) {
        paramVarArgs.d(7, this.FMn);
      }
      if (this.FMo != null) {
        paramVarArgs.d(8, this.FMo);
      }
      if (this.FMp != null) {
        paramVarArgs.d(9, this.FMp);
      }
      if (this.FMq != null) {
        paramVarArgs.d(10, this.FMq);
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.opType) + 0 + f.a.a.b.b.a.bx(2, this.hTO) + f.a.a.b.b.a.bx(3, this.hTL) + f.a.a.b.b.a.p(4, this.timeStamp) + f.a.a.b.b.a.bx(5, this.hTM) + f.a.a.b.b.a.bx(6, this.hTN);
      paramInt = i;
      if (this.FMn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FMn);
      }
      i = paramInt;
      if (this.FMo != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FMo);
      }
      paramInt = i;
      if (this.FMp != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FMp);
      }
      i = paramInt;
      if (this.FMq != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FMq);
      }
      AppMethodBeat.o(125841);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FMn == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.FMo == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.FMp == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.FMq == null)
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
      dcr localdcr = (dcr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125841);
        return -1;
      case 1: 
        localdcr.opType = locala.LVo.xF();
        AppMethodBeat.o(125841);
        return 0;
      case 2: 
        localdcr.hTO = locala.LVo.xF();
        AppMethodBeat.o(125841);
        return 0;
      case 3: 
        localdcr.hTL = locala.LVo.xF();
        AppMethodBeat.o(125841);
        return 0;
      case 4: 
        localdcr.timeStamp = locala.LVo.xG();
        AppMethodBeat.o(125841);
        return 0;
      case 5: 
        localdcr.hTM = locala.LVo.xF();
        AppMethodBeat.o(125841);
        return 0;
      case 6: 
        localdcr.hTN = locala.LVo.xF();
        AppMethodBeat.o(125841);
        return 0;
      case 7: 
        localdcr.FMn = locala.LVo.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 8: 
        localdcr.FMo = locala.LVo.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 9: 
        localdcr.FMp = locala.LVo.readString();
        AppMethodBeat.o(125841);
        return 0;
      }
      localdcr.FMq = locala.LVo.readString();
      AppMethodBeat.o(125841);
      return 0;
    }
    AppMethodBeat.o(125841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcr
 * JD-Core Version:    0.7.0.1
 */