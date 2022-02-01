package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class es
  extends cpx
{
  public LinkedList<yj> DRk;
  public int DRl;
  public int DRm;
  public String session_id;
  public String url;
  
  public es()
  {
    AppMethodBeat.i(103186);
    this.DRk = new LinkedList();
    AppMethodBeat.o(103186);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103187);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.e(4, 8, this.DRk);
      if (this.session_id != null) {
        paramVarArgs.d(5, this.session_id);
      }
      paramVarArgs.aR(6, this.DRl);
      paramVarArgs.aR(7, this.DRm);
      AppMethodBeat.o(103187);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.a.c(4, 8, this.DRk);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.session_id);
      }
      i = f.a.a.b.b.a.bx(6, this.DRl);
      int j = f.a.a.b.b.a.bx(7, this.DRm);
      AppMethodBeat.o(103187);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103187);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        es locales = (es)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103187);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locales.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 2: 
          locales.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locales.DRk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 5: 
          locales.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 6: 
          locales.DRl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103187);
          return 0;
        }
        locales.DRm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103187);
        return 0;
      }
      AppMethodBeat.o(103187);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.es
 * JD-Core Version:    0.7.0.1
 */