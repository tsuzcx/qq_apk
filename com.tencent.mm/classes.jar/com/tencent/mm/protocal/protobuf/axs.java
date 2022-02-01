package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axs
  extends cwj
{
  public LinkedList<String> Dgl;
  public String GOM;
  public int dmy;
  public String phe;
  
  public axs()
  {
    AppMethodBeat.i(91484);
    this.Dgl = new LinkedList();
    AppMethodBeat.o(91484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Dgl);
      paramVarArgs.aS(3, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(4, this.phe);
      }
      if (this.GOM != null) {
        paramVarArgs.d(5, this.GOM);
      }
      AppMethodBeat.o(91485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.Dgl) + f.a.a.b.b.a.bz(3, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.phe);
      }
      i = paramInt;
      if (this.GOM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GOM);
      }
      AppMethodBeat.o(91485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dgl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axs localaxs = (axs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91485);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91485);
          return 0;
        case 2: 
          localaxs.Dgl.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91485);
          return 0;
        case 3: 
          localaxs.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91485);
          return 0;
        case 4: 
          localaxs.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91485);
          return 0;
        }
        localaxs.GOM = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91485);
        return 0;
      }
      AppMethodBeat.o(91485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axs
 * JD-Core Version:    0.7.0.1
 */