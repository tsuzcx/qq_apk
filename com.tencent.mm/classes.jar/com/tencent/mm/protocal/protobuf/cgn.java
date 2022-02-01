package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgn
  extends erp
{
  public String YBb;
  public String YBc;
  public int YBd;
  public LinkedList<wf> YBg;
  public String aapy;
  public int iaK;
  public String sign;
  public String xlr;
  public String xme;
  
  public cgn()
  {
    AppMethodBeat.i(114012);
    this.YBg = new LinkedList();
    AppMethodBeat.o(114012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114013);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YBg);
      paramVarArgs.bS(3, this.iaK);
      if (this.xme != null) {
        paramVarArgs.g(4, this.xme);
      }
      if (this.xlr != null) {
        paramVarArgs.g(5, this.xlr);
      }
      if (this.sign != null) {
        paramVarArgs.g(6, this.sign);
      }
      if (this.YBb != null) {
        paramVarArgs.g(7, this.YBb);
      }
      if (this.YBc != null) {
        paramVarArgs.g(8, this.YBc);
      }
      if (this.aapy != null) {
        paramVarArgs.g(9, this.aapy);
      }
      paramVarArgs.bS(10, this.YBd);
      AppMethodBeat.o(114013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YBg) + i.a.a.b.b.a.cJ(3, this.iaK);
      paramInt = i;
      if (this.xme != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xme);
      }
      i = paramInt;
      if (this.xlr != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.xlr);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.sign);
      }
      i = paramInt;
      if (this.YBb != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YBb);
      }
      paramInt = i;
      if (this.YBc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YBc);
      }
      i = paramInt;
      if (this.aapy != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aapy);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.YBd);
      AppMethodBeat.o(114013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YBg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cgn localcgn = (cgn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114013);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcgn.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wf)localObject2).parseFrom((byte[])localObject1);
            }
            localcgn.YBg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 3: 
          localcgn.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114013);
          return 0;
        case 4: 
          localcgn.xme = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 5: 
          localcgn.xlr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 6: 
          localcgn.sign = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 7: 
          localcgn.YBb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 8: 
          localcgn.YBc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 9: 
          localcgn.aapy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114013);
          return 0;
        }
        localcgn.YBd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(114013);
        return 0;
      }
      AppMethodBeat.o(114013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgn
 * JD-Core Version:    0.7.0.1
 */