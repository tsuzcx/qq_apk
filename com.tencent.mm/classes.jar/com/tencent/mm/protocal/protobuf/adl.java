package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adl
  extends cpx
{
  public String djj;
  public String key;
  public String query;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123568);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.key != null) {
        paramVarArgs.d(2, this.key);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      if (this.query != null) {
        paramVarArgs.d(4, this.query);
      }
      paramVarArgs.aR(5, this.scene);
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      AppMethodBeat.o(123568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.key);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.query);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.url);
      }
      AppMethodBeat.o(123568);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adl localadl = (adl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123568);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadl.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123568);
          return 0;
        case 2: 
          localadl.key = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 3: 
          localadl.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 4: 
          localadl.query = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123568);
          return 0;
        case 5: 
          localadl.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123568);
          return 0;
        }
        localadl.url = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123568);
        return 0;
      }
      AppMethodBeat.o(123568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adl
 * JD-Core Version:    0.7.0.1
 */