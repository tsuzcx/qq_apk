package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awi
  extends com.tencent.mm.bw.a
{
  public cpw EOl;
  public bqz EOm;
  public int EOn;
  public boolean EOo;
  public boolean EOp;
  public int EOq;
  public int Eeo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EOl != null)
      {
        paramVarArgs.ln(1, this.EOl.computeSize());
        this.EOl.writeFields(paramVarArgs);
      }
      if (this.EOm != null)
      {
        paramVarArgs.ln(2, this.EOm.computeSize());
        this.EOm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EOn);
      paramVarArgs.aR(4, this.Eeo);
      paramVarArgs.bl(5, this.EOo);
      paramVarArgs.bl(6, this.EOp);
      paramVarArgs.aR(7, this.EOq);
      AppMethodBeat.o(175244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EOl == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.lm(1, this.EOl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EOm != null) {
        i = paramInt + f.a.a.a.lm(2, this.EOm.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.EOn);
      int j = f.a.a.b.b.a.bx(4, this.Eeo);
      int k = f.a.a.b.b.a.fK(5);
      int m = f.a.a.b.b.a.fK(6);
      int n = f.a.a.b.b.a.bx(7, this.EOq);
      AppMethodBeat.o(175244);
      return i + paramInt + j + (k + 1) + (m + 1) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(175244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awi localawi = (awi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175244);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawi.EOl = ((cpw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawi.EOm = ((bqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 3: 
          localawi.EOn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(175244);
          return 0;
        case 4: 
          localawi.Eeo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(175244);
          return 0;
        case 5: 
          localawi.EOo = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(175244);
          return 0;
        case 6: 
          localawi.EOp = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(175244);
          return 0;
        }
        localawi.EOq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(175244);
        return 0;
      }
      AppMethodBeat.o(175244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awi
 * JD-Core Version:    0.7.0.1
 */