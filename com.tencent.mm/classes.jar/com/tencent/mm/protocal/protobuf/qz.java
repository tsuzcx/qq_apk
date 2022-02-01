package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qz
  extends com.tencent.mm.bw.a
{
  public rm EiA;
  public int EiB;
  public String Eiw;
  public String Eix;
  public String Eiy;
  public int Eiz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eiw != null) {
        paramVarArgs.d(1, this.Eiw);
      }
      if (this.Eix != null) {
        paramVarArgs.d(2, this.Eix);
      }
      if (this.Eiy != null) {
        paramVarArgs.d(3, this.Eiy);
      }
      paramVarArgs.aR(4, this.Eiz);
      if (this.EiA != null)
      {
        paramVarArgs.ln(5, this.EiA.computeSize());
        this.EiA.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.EiB);
      AppMethodBeat.o(113950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eiw == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.Eiw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eix != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eix);
      }
      i = paramInt;
      if (this.Eiy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eiy);
      }
      i += f.a.a.b.b.a.bx(4, this.Eiz);
      paramInt = i;
      if (this.EiA != null) {
        paramInt = i + f.a.a.a.lm(5, this.EiA.computeSize());
      }
      i = f.a.a.b.b.a.bx(6, this.EiB);
      AppMethodBeat.o(113950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qz localqz = (qz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113950);
          return -1;
        case 1: 
          localqz.Eiw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 2: 
          localqz.Eix = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 3: 
          localqz.Eiy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 4: 
          localqz.Eiz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113950);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqz.EiA = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113950);
          return 0;
        }
        localqz.EiB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113950);
        return 0;
      }
      AppMethodBeat.o(113950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qz
 * JD-Core Version:    0.7.0.1
 */