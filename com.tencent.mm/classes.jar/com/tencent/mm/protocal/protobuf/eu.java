package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eu
  extends cpx
{
  public int DRl;
  public int DRm;
  public int DRn;
  public long DRo;
  public int nWg;
  public int offset;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103189);
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
      paramVarArgs.aR(4, this.offset);
      paramVarArgs.aR(6, this.nWg);
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.aR(8, this.DRn);
      paramVarArgs.aR(9, this.DRm);
      paramVarArgs.aR(10, this.DRl);
      if (this.session_id != null) {
        paramVarArgs.d(11, this.session_id);
      }
      paramVarArgs.aO(12, this.DRo);
      AppMethodBeat.o(103189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i = i + f.a.a.b.b.a.bx(4, this.offset) + f.a.a.b.b.a.bx(6, this.nWg) + f.a.a.b.b.a.bx(7, this.scene) + f.a.a.b.b.a.bx(8, this.DRn) + f.a.a.b.b.a.bx(9, this.DRm) + f.a.a.b.b.a.bx(10, this.DRl);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.session_id);
      }
      i = f.a.a.b.b.a.p(12, this.DRo);
      AppMethodBeat.o(103189);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103189);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eu localeu = (eu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 5: 
        default: 
          AppMethodBeat.o(103189);
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
            localeu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103189);
          return 0;
        case 2: 
          localeu.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103189);
          return 0;
        case 4: 
          localeu.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103189);
          return 0;
        case 6: 
          localeu.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103189);
          return 0;
        case 7: 
          localeu.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103189);
          return 0;
        case 8: 
          localeu.DRn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103189);
          return 0;
        case 9: 
          localeu.DRm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103189);
          return 0;
        case 10: 
          localeu.DRl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103189);
          return 0;
        case 11: 
          localeu.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103189);
          return 0;
        }
        localeu.DRo = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(103189);
        return 0;
      }
      AppMethodBeat.o(103189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eu
 * JD-Core Version:    0.7.0.1
 */