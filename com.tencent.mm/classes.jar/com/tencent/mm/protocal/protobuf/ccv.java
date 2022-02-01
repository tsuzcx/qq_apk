package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccv
  extends com.tencent.mm.bw.a
{
  public String Frs;
  public String Frt;
  public String Fru;
  public int Frv;
  public String Frw;
  public rm Frx;
  public String Fry;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114049);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Frs != null) {
        paramVarArgs.d(1, this.Frs);
      }
      if (this.Frt != null) {
        paramVarArgs.d(2, this.Frt);
      }
      if (this.Fru != null) {
        paramVarArgs.d(3, this.Fru);
      }
      paramVarArgs.aR(4, this.Frv);
      if (this.Frw != null) {
        paramVarArgs.d(5, this.Frw);
      }
      if (this.Frx != null)
      {
        paramVarArgs.ln(6, this.Frx.computeSize());
        this.Frx.writeFields(paramVarArgs);
      }
      if (this.Fry != null) {
        paramVarArgs.d(7, this.Fry);
      }
      AppMethodBeat.o(114049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Frs == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.Frs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Frt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Frt);
      }
      i = paramInt;
      if (this.Fru != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fru);
      }
      i += f.a.a.b.b.a.bx(4, this.Frv);
      paramInt = i;
      if (this.Frw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Frw);
      }
      i = paramInt;
      if (this.Frx != null) {
        i = paramInt + f.a.a.a.lm(6, this.Frx.computeSize());
      }
      paramInt = i;
      if (this.Fry != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fry);
      }
      AppMethodBeat.o(114049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccv localccv = (ccv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114049);
          return -1;
        case 1: 
          localccv.Frs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 2: 
          localccv.Frt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 3: 
          localccv.Fru = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 4: 
          localccv.Frv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114049);
          return 0;
        case 5: 
          localccv.Frw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccv.Frx = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114049);
          return 0;
        }
        localccv.Fry = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114049);
        return 0;
      }
      AppMethodBeat.o(114049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccv
 * JD-Core Version:    0.7.0.1
 */