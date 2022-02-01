package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends erp
{
  public String YzM;
  public LinkedList<m> YzQ;
  public bi YzR;
  public long YzS;
  public String YzT;
  public String YzU;
  public String YzV;
  public String YzW;
  public long YzZ;
  public int scene;
  public String title;
  
  public k()
  {
    AppMethodBeat.i(91318);
    this.YzQ = new LinkedList();
    AppMethodBeat.o(91318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91319);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      paramVarArgs.bv(3, this.YzZ);
      paramVarArgs.e(5, 8, this.YzQ);
      paramVarArgs.bS(7, this.scene);
      if (this.YzM != null) {
        paramVarArgs.g(8, this.YzM);
      }
      if (this.YzR != null)
      {
        paramVarArgs.qD(9, this.YzR.computeSize());
        this.YzR.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(10, this.YzS);
      if (this.YzT != null) {
        paramVarArgs.g(11, this.YzT);
      }
      if (this.YzU != null) {
        paramVarArgs.g(12, this.YzU);
      }
      if (this.YzV != null) {
        paramVarArgs.g(13, this.YzV);
      }
      if (this.YzW != null) {
        paramVarArgs.g(14, this.YzW);
      }
      AppMethodBeat.o(91319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1048;
      }
    }
    label1048:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.title);
      }
      i = i + i.a.a.b.b.a.q(3, this.YzZ) + i.a.a.a.c(5, 8, this.YzQ) + i.a.a.b.b.a.cJ(7, this.scene);
      paramInt = i;
      if (this.YzM != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YzM);
      }
      i = paramInt;
      if (this.YzR != null) {
        i = paramInt + i.a.a.a.qC(9, this.YzR.computeSize());
      }
      i += i.a.a.b.b.a.q(10, this.YzS);
      paramInt = i;
      if (this.YzT != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YzT);
      }
      i = paramInt;
      if (this.YzU != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YzU);
      }
      paramInt = i;
      if (this.YzV != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YzV);
      }
      i = paramInt;
      if (this.YzW != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.YzW);
      }
      AppMethodBeat.o(91319);
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
        AppMethodBeat.o(91319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(91319);
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
            localk.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 2: 
          localk.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 3: 
          localk.YzZ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91319);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localk.YzQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 7: 
          localk.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91319);
          return 0;
        case 8: 
          localk.YzM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 9: 
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
            localk.YzR = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 10: 
          localk.YzS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91319);
          return 0;
        case 11: 
          localk.YzT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 12: 
          localk.YzU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 13: 
          localk.YzV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91319);
          return 0;
        }
        localk.YzW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91319);
        return 0;
      }
      AppMethodBeat.o(91319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.k
 * JD-Core Version:    0.7.0.1
 */