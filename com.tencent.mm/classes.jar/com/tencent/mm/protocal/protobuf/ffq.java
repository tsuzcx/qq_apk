package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ffq
  extends esc
{
  public long Id;
  public int NkN;
  public int NkO;
  public int aaUf;
  public LinkedList<fds> aaUg;
  public fds abFD;
  public String nUv;
  public int vhJ;
  
  public ffq()
  {
    AppMethodBeat.i(125831);
    this.aaUg = new LinkedList();
    AppMethodBeat.o(125831);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125832);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.abFD == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkO);
      paramVarArgs.bS(3, this.NkN);
      if (this.nUv != null) {
        paramVarArgs.g(4, this.nUv);
      }
      if (this.abFD != null)
      {
        paramVarArgs.qD(5, this.abFD.computeSize());
        this.abFD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.aaUf);
      paramVarArgs.e(7, 8, this.aaUg);
      paramVarArgs.bv(8, this.Id);
      paramVarArgs.bS(9, this.vhJ);
      AppMethodBeat.o(125832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label924;
      }
    }
    label924:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkO) + i.a.a.b.b.a.cJ(3, this.NkN);
      paramInt = i;
      if (this.nUv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUv);
      }
      i = paramInt;
      if (this.abFD != null) {
        i = paramInt + i.a.a.a.qC(5, this.abFD.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.aaUf);
      int j = i.a.a.a.c(7, 8, this.aaUg);
      int k = i.a.a.b.b.a.q(8, this.Id);
      int m = i.a.a.b.b.a.cJ(9, this.vhJ);
      AppMethodBeat.o(125832);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaUg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        if (this.abFD == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ffq localffq = (ffq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125832);
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
            localffq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 2: 
          localffq.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125832);
          return 0;
        case 3: 
          localffq.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125832);
          return 0;
        case 4: 
          localffq.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125832);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fds();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fds)localObject2).parseFrom((byte[])localObject1);
            }
            localffq.abFD = ((fds)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 6: 
          localffq.aaUf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125832);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fds();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fds)localObject2).parseFrom((byte[])localObject1);
            }
            localffq.aaUg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 8: 
          localffq.Id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125832);
          return 0;
        }
        localffq.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125832);
        return 0;
      }
      AppMethodBeat.o(125832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffq
 * JD-Core Version:    0.7.0.1
 */