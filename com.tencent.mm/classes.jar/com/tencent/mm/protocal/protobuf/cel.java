package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cel
  extends com.tencent.mm.bw.a
{
  public String AZE;
  public String AZF;
  public String BnF;
  public cnd Ftj;
  public String desc;
  public String hhs;
  public String name;
  public String title;
  public int vjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.hhs != null) {
        paramVarArgs.d(4, this.hhs);
      }
      paramVarArgs.aR(5, this.vjP);
      if (this.BnF != null) {
        paramVarArgs.d(6, this.BnF);
      }
      if (this.AZE != null) {
        paramVarArgs.d(7, this.AZE);
      }
      if (this.AZF != null) {
        paramVarArgs.d(8, this.AZF);
      }
      if (this.Ftj != null)
      {
        paramVarArgs.ln(9, this.Ftj.computeSize());
        this.Ftj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hhs);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.vjP);
      paramInt = i;
      if (this.BnF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.BnF);
      }
      i = paramInt;
      if (this.AZE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.AZE);
      }
      paramInt = i;
      if (this.AZF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.AZF);
      }
      i = paramInt;
      if (this.Ftj != null) {
        i = paramInt + f.a.a.a.lm(9, this.Ftj.computeSize());
      }
      AppMethodBeat.o(72542);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cel localcel = (cel)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72542);
          return -1;
        case 1: 
          localcel.name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 2: 
          localcel.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 3: 
          localcel.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 4: 
          localcel.hhs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 5: 
          localcel.vjP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72542);
          return 0;
        case 6: 
          localcel.BnF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 7: 
          localcel.AZE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 8: 
          localcel.AZF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72542);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cnd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcel.Ftj = ((cnd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      AppMethodBeat.o(72542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cel
 * JD-Core Version:    0.7.0.1
 */