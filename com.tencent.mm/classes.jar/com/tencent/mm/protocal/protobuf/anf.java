package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anf
  extends dyl
{
  public String HlB;
  public int RLe;
  public float ScO;
  public float ScP;
  public String Sxs;
  public int Sxt;
  public String Sxu;
  public String Sxv;
  public int Sxw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32207);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      if (this.Sxs != null) {
        paramVarArgs.f(3, this.Sxs);
      }
      paramVarArgs.i(4, this.ScO);
      paramVarArgs.i(5, this.ScP);
      paramVarArgs.aY(6, this.Sxt);
      if (this.Sxu != null) {
        paramVarArgs.f(7, this.Sxu);
      }
      if (this.Sxv != null) {
        paramVarArgs.f(8, this.Sxv);
      }
      paramVarArgs.aY(9, this.Sxw);
      if (this.HlB != null) {
        paramVarArgs.f(10, this.HlB);
      }
      AppMethodBeat.o(32207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe);
      paramInt = i;
      if (this.Sxs != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Sxs);
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 4) + (g.a.a.b.b.a.gL(5) + 4) + g.a.a.b.b.a.bM(6, this.Sxt);
      paramInt = i;
      if (this.Sxu != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sxu);
      }
      i = paramInt;
      if (this.Sxv != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Sxv);
      }
      i += g.a.a.b.b.a.bM(9, this.Sxw);
      paramInt = i;
      if (this.HlB != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.HlB);
      }
      AppMethodBeat.o(32207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        anf localanf = (anf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32207);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localanf.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32207);
          return 0;
        case 2: 
          localanf.RLe = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32207);
          return 0;
        case 3: 
          localanf.Sxs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 4: 
          localanf.ScO = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(32207);
          return 0;
        case 5: 
          localanf.ScP = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(32207);
          return 0;
        case 6: 
          localanf.Sxt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32207);
          return 0;
        case 7: 
          localanf.Sxu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 8: 
          localanf.Sxv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 9: 
          localanf.Sxw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32207);
          return 0;
        }
        localanf.HlB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32207);
        return 0;
      }
      AppMethodBeat.o(32207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anf
 * JD-Core Version:    0.7.0.1
 */