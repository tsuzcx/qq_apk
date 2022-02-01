package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vp
  extends cwj
{
  public String Gnq;
  public boolean Gnr;
  public int dmy;
  public String phe;
  public int yoX;
  public String ywk;
  public String ywl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72449);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.Gnq != null) {
        paramVarArgs.d(4, this.Gnq);
      }
      if (this.ywk != null) {
        paramVarArgs.d(5, this.ywk);
      }
      paramVarArgs.bC(6, this.Gnr);
      if (this.ywl != null) {
        paramVarArgs.d(7, this.ywl);
      }
      paramVarArgs.aS(8, this.yoX);
      AppMethodBeat.o(72449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.Gnq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Gnq);
      }
      paramInt = i;
      if (this.ywk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ywk);
      }
      i = paramInt + f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.ywl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ywl);
      }
      i = f.a.a.b.b.a.bz(8, this.yoX);
      AppMethodBeat.o(72449);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vp localvp = (vp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72449);
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
            localvp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72449);
          return 0;
        case 2: 
          localvp.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72449);
          return 0;
        case 3: 
          localvp.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 4: 
          localvp.Gnq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 5: 
          localvp.ywk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 6: 
          localvp.Gnr = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72449);
          return 0;
        case 7: 
          localvp.ywl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72449);
          return 0;
        }
        localvp.yoX = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72449);
        return 0;
      }
      AppMethodBeat.o(72449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vp
 * JD-Core Version:    0.7.0.1
 */