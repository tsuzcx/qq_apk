package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iz
  extends erp
{
  public int IJG;
  public int YKK;
  public LinkedList<afx> YKL;
  public String YKM;
  public String YKN;
  public String YKO;
  public String YKP;
  public long vhg;
  
  public iz()
  {
    AppMethodBeat.i(32131);
    this.YKL = new LinkedList();
    AppMethodBeat.o(32131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32132);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YKK);
      paramVarArgs.e(3, 8, this.YKL);
      if (this.YKM != null) {
        paramVarArgs.g(4, this.YKM);
      }
      if (this.YKN != null) {
        paramVarArgs.g(5, this.YKN);
      }
      paramVarArgs.bS(6, this.IJG);
      paramVarArgs.bv(7, this.vhg);
      if (this.YKO != null) {
        paramVarArgs.g(8, this.YKO);
      }
      if (this.YKP != null) {
        paramVarArgs.g(9, this.YKP);
      }
      AppMethodBeat.o(32132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YKK) + i.a.a.a.c(3, 8, this.YKL);
      paramInt = i;
      if (this.YKM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YKM);
      }
      i = paramInt;
      if (this.YKN != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YKN);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.IJG) + i.a.a.b.b.a.q(7, this.vhg);
      paramInt = i;
      if (this.YKO != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YKO);
      }
      i = paramInt;
      if (this.YKP != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YKP);
      }
      AppMethodBeat.o(32132);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YKL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32132);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        iz localiz = (iz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32132);
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
            localiz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32132);
          return 0;
        case 2: 
          localiz.YKK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32132);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afx)localObject2).parseFrom((byte[])localObject1);
            }
            localiz.YKL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32132);
          return 0;
        case 4: 
          localiz.YKM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32132);
          return 0;
        case 5: 
          localiz.YKN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32132);
          return 0;
        case 6: 
          localiz.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32132);
          return 0;
        case 7: 
          localiz.vhg = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(32132);
          return 0;
        case 8: 
          localiz.YKO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32132);
          return 0;
        }
        localiz.YKP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32132);
        return 0;
      }
      AppMethodBeat.o(32132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iz
 * JD-Core Version:    0.7.0.1
 */