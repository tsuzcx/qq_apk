package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class fao
  extends dyl
{
  public eae RMM;
  public eae RMN;
  public int RNt;
  public String Tlm;
  public int UAA;
  public LinkedList<fan> UAB;
  public int UAC;
  public String UAD;
  public int UAw;
  public LinkedList<fal> UAx;
  public int UAy;
  public LinkedList<Integer> UAz;
  
  public fao()
  {
    AppMethodBeat.i(152726);
    this.UAx = new LinkedList();
    this.UAz = new LinkedList();
    this.UAB = new LinkedList();
    AppMethodBeat.o(152726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152727);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RNt);
      paramVarArgs.aY(3, this.UAw);
      paramVarArgs.e(4, 8, this.UAx);
      if (this.Tlm != null) {
        paramVarArgs.f(5, this.Tlm);
      }
      paramVarArgs.aY(6, this.UAy);
      paramVarArgs.f(7, 2, this.UAz);
      paramVarArgs.aY(8, this.UAA);
      paramVarArgs.e(9, 8, this.UAB);
      if (this.RMM != null)
      {
        paramVarArgs.oE(10, this.RMM.computeSize());
        this.RMM.writeFields(paramVarArgs);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(11, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.UAC);
      if (this.UAD != null) {
        paramVarArgs.f(13, this.UAD);
      }
      AppMethodBeat.o(152727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1207;
      }
    }
    label1207:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RNt) + g.a.a.b.b.a.bM(3, this.UAw) + g.a.a.a.c(4, 8, this.UAx);
      paramInt = i;
      if (this.Tlm != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tlm);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.UAy) + g.a.a.a.d(7, 2, this.UAz) + g.a.a.b.b.a.bM(8, this.UAA) + g.a.a.a.c(9, 8, this.UAB);
      paramInt = i;
      if (this.RMM != null) {
        paramInt = i + g.a.a.a.oD(10, this.RMM.computeSize());
      }
      i = paramInt;
      if (this.RMN != null) {
        i = paramInt + g.a.a.a.oD(11, this.RMN.computeSize());
      }
      i += g.a.a.b.b.a.bM(12, this.UAC);
      paramInt = i;
      if (this.UAD != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.UAD);
      }
      AppMethodBeat.o(152727);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UAx.clear();
        this.UAz.clear();
        this.UAB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fao localfao = (fao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152727);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfao.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 2: 
          localfao.RNt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152727);
          return 0;
        case 3: 
          localfao.UAw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152727);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fal();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fal)localObject2).parseFrom((byte[])localObject1);
            }
            localfao.UAx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 5: 
          localfao.Tlm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152727);
          return 0;
        case 6: 
          localfao.UAy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152727);
          return 0;
        case 7: 
          localfao.UAz = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(152727);
          return 0;
        case 8: 
          localfao.UAA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152727);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fan();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fan)localObject2).parseFrom((byte[])localObject1);
            }
            localfao.UAB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localfao.RMM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localfao.RMN = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 12: 
          localfao.UAC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152727);
          return 0;
        }
        localfao.UAD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152727);
        return 0;
      }
      AppMethodBeat.o(152727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fao
 * JD-Core Version:    0.7.0.1
 */