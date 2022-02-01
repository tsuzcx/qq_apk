package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctx
  extends cpx
{
  public int Eeo;
  public String Ekn;
  public String ErI;
  public String FFE;
  public int dbL;
  public String djj;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ErI != null) {
        paramVarArgs.d(2, this.ErI);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.FFE != null) {
        paramVarArgs.d(5, this.FFE);
      }
      paramVarArgs.aR(6, this.scene);
      paramVarArgs.aR(7, this.dbL);
      if (this.Ekn != null) {
        paramVarArgs.d(8, this.Ekn);
      }
      paramVarArgs.aR(9, this.Eeo);
      AppMethodBeat.o(91683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ErI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ErI);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.FFE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FFE);
      }
      i = i + f.a.a.b.b.a.bx(6, this.scene) + f.a.a.b.b.a.bx(7, this.dbL);
      paramInt = i;
      if (this.Ekn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Ekn);
      }
      i = f.a.a.b.b.a.bx(9, this.Eeo);
      AppMethodBeat.o(91683);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctx localctx = (ctx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91683);
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
            localctx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91683);
          return 0;
        case 2: 
          localctx.ErI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 3: 
          localctx.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 4: 
          localctx.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 5: 
          localctx.FFE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 6: 
          localctx.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91683);
          return 0;
        case 7: 
          localctx.dbL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91683);
          return 0;
        case 8: 
          localctx.Ekn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91683);
          return 0;
        }
        localctx.Eeo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91683);
        return 0;
      }
      AppMethodBeat.o(91683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctx
 * JD-Core Version:    0.7.0.1
 */