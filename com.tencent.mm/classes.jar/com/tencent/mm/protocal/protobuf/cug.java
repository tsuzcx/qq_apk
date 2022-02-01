package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cug
  extends esc
{
  public int aazG;
  public String aazH;
  public int aazI;
  public String aazJ;
  public int aazK;
  public LinkedList<etl> aazL;
  public String aazM;
  public int aazN;
  public String aazO;
  public int aazP;
  public gol aazQ;
  
  public cug()
  {
    AppMethodBeat.i(152605);
    this.aazL = new LinkedList();
    AppMethodBeat.o(152605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152606);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aazG);
      if (this.aazH != null) {
        paramVarArgs.g(3, this.aazH);
      }
      paramVarArgs.bS(4, this.aazI);
      if (this.aazJ != null) {
        paramVarArgs.g(5, this.aazJ);
      }
      paramVarArgs.bS(6, this.aazK);
      paramVarArgs.e(7, 8, this.aazL);
      if (this.aazM != null) {
        paramVarArgs.g(8, this.aazM);
      }
      paramVarArgs.bS(9, this.aazN);
      if (this.aazO != null) {
        paramVarArgs.g(10, this.aazO);
      }
      paramVarArgs.bS(11, this.aazP);
      if (this.aazQ != null)
      {
        paramVarArgs.qD(12, this.aazQ.computeSize());
        this.aazQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1056;
      }
    }
    label1056:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aazG);
      paramInt = i;
      if (this.aazH != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aazH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aazI);
      paramInt = i;
      if (this.aazJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aazJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aazK) + i.a.a.a.c(7, 8, this.aazL);
      paramInt = i;
      if (this.aazM != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aazM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.aazN);
      paramInt = i;
      if (this.aazO != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aazO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aazP);
      paramInt = i;
      if (this.aazQ != null) {
        paramInt = i + i.a.a.a.qC(12, this.aazQ.computeSize());
      }
      AppMethodBeat.o(152606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aazL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cug localcug = (cug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152606);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcug.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 2: 
          localcug.aazG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152606);
          return 0;
        case 3: 
          localcug.aazH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 4: 
          localcug.aazI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152606);
          return 0;
        case 5: 
          localcug.aazJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 6: 
          localcug.aazK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152606);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcug.aazL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 8: 
          localcug.aazM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 9: 
          localcug.aazN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152606);
          return 0;
        case 10: 
          localcug.aazO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 11: 
          localcug.aazP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152606);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localcug.aazQ = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      AppMethodBeat.o(152606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cug
 * JD-Core Version:    0.7.0.1
 */