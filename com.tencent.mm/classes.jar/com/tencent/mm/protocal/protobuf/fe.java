package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fe
  extends cpx
{
  public int DRl;
  public int DRm;
  public int DRn;
  public String DSo;
  public String hED;
  public int nWg;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103197);
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
      if (this.hED != null) {
        paramVarArgs.d(3, this.hED);
      }
      if (this.DSo != null) {
        paramVarArgs.d(4, this.DSo);
      }
      paramVarArgs.aR(5, this.scene);
      paramVarArgs.aR(6, this.DRn);
      paramVarArgs.aR(7, this.DRm);
      paramVarArgs.aR(8, this.nWg);
      paramVarArgs.aR(10, this.DRl);
      if (this.session_id != null) {
        paramVarArgs.d(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hED != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hED);
      }
      paramInt = i;
      if (this.DSo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DSo);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.scene) + f.a.a.b.b.a.bx(6, this.DRn) + f.a.a.b.b.a.bx(7, this.DRm) + f.a.a.b.b.a.bx(8, this.nWg) + f.a.a.b.b.a.bx(10, this.DRl);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fe localfe = (fe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(103197);
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
            localfe.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103197);
          return 0;
        case 2: 
          localfe.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 3: 
          localfe.hED = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 4: 
          localfe.DSo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 5: 
          localfe.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103197);
          return 0;
        case 6: 
          localfe.DRn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103197);
          return 0;
        case 7: 
          localfe.DRm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103197);
          return 0;
        case 8: 
          localfe.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103197);
          return 0;
        case 10: 
          localfe.DRl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103197);
          return 0;
        }
        localfe.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103197);
        return 0;
      }
      AppMethodBeat.o(103197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fe
 * JD-Core Version:    0.7.0.1
 */