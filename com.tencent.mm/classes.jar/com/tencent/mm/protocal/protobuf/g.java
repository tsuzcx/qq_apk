package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends erp
{
  public String YzM;
  public int YzO;
  public long YzP;
  public LinkedList<String> YzQ;
  public bi YzR;
  public long YzS;
  public String YzT;
  public String YzU;
  public String YzV;
  public String YzW;
  public int scene;
  public String title;
  
  public g()
  {
    AppMethodBeat.i(91315);
    this.YzQ = new LinkedList();
    AppMethodBeat.o(91315);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91316);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YzO);
      paramVarArgs.bv(3, this.YzP);
      if (this.title != null) {
        paramVarArgs.g(4, this.title);
      }
      paramVarArgs.e(5, 1, this.YzQ);
      paramVarArgs.bS(6, this.scene);
      if (this.YzM != null) {
        paramVarArgs.g(7, this.YzM);
      }
      if (this.YzR != null)
      {
        paramVarArgs.qD(8, this.YzR.computeSize());
        this.YzR.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(9, this.YzS);
      if (this.YzT != null) {
        paramVarArgs.g(10, this.YzT);
      }
      if (this.YzU != null) {
        paramVarArgs.g(11, this.YzU);
      }
      if (this.YzV != null) {
        paramVarArgs.g(12, this.YzV);
      }
      if (this.YzW != null) {
        paramVarArgs.g(13, this.YzW);
      }
      AppMethodBeat.o(91316);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YzO) + i.a.a.b.b.a.q(3, this.YzP);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.title);
      }
      i = paramInt + i.a.a.a.c(5, 1, this.YzQ) + i.a.a.b.b.a.cJ(6, this.scene);
      paramInt = i;
      if (this.YzM != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YzM);
      }
      i = paramInt;
      if (this.YzR != null) {
        i = paramInt + i.a.a.a.qC(8, this.YzR.computeSize());
      }
      i += i.a.a.b.b.a.q(9, this.YzS);
      paramInt = i;
      if (this.YzT != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YzT);
      }
      i = paramInt;
      if (this.YzU != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YzU);
      }
      paramInt = i;
      if (this.YzV != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YzV);
      }
      i = paramInt;
      if (this.YzW != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YzW);
      }
      AppMethodBeat.o(91316);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YzQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91316);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91316);
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
            localg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 2: 
          localg.YzO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91316);
          return 0;
        case 3: 
          localg.YzP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91316);
          return 0;
        case 4: 
          localg.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 5: 
          localg.YzQ.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91316);
          return 0;
        case 6: 
          localg.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91316);
          return 0;
        case 7: 
          localg.YzM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bi)localObject2).parseFrom((byte[])localObject1);
            }
            localg.YzR = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 9: 
          localg.YzS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91316);
          return 0;
        case 10: 
          localg.YzT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 11: 
          localg.YzU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 12: 
          localg.YzV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91316);
          return 0;
        }
        localg.YzW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91316);
        return 0;
      }
      AppMethodBeat.o(91316);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.g
 * JD-Core Version:    0.7.0.1
 */