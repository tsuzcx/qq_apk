package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fc
  extends cpx
{
  public int DRl;
  public int DRm;
  public int DRn;
  public int DSk;
  public String DSl;
  public int DSm;
  public int DSn;
  public int nWg;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177339);
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
      paramVarArgs.aR(5, this.DSk);
      if (this.DSl != null) {
        paramVarArgs.d(6, this.DSl);
      }
      paramVarArgs.aR(7, this.DSm);
      paramVarArgs.aR(8, this.nWg);
      paramVarArgs.aR(9, this.DSn);
      paramVarArgs.aR(10, this.scene);
      paramVarArgs.aR(11, this.DRn);
      paramVarArgs.aR(12, this.DRm);
      paramVarArgs.aR(13, this.DRl);
      if (this.session_id != null) {
        paramVarArgs.d(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.b.b.a.bx(5, this.DSk);
      paramInt = i;
      if (this.DSl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DSl);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.DSm) + f.a.a.b.b.a.bx(8, this.nWg) + f.a.a.b.b.a.bx(9, this.DSn) + f.a.a.b.b.a.bx(10, this.scene) + f.a.a.b.b.a.bx(11, this.DRn) + f.a.a.b.b.a.bx(12, this.DRm) + f.a.a.b.b.a.bx(13, this.DRl);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(177339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fc localfc = (fc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(177339);
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
            localfc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177339);
          return 0;
        case 2: 
          localfc.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 5: 
          localfc.DSk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        case 6: 
          localfc.DSl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 7: 
          localfc.DSm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        case 8: 
          localfc.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        case 9: 
          localfc.DSn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        case 10: 
          localfc.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        case 11: 
          localfc.DRn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        case 12: 
          localfc.DRm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        case 13: 
          localfc.DRl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(177339);
          return 0;
        }
        localfc.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(177339);
        return 0;
      }
      AppMethodBeat.o(177339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fc
 * JD-Core Version:    0.7.0.1
 */