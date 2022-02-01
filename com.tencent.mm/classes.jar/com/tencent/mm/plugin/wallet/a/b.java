package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public m zNZ;
  public int zOa;
  public String zOb;
  public String zOc;
  public String zOd;
  public String zOe;
  public String zOf;
  public String zOg;
  public String zOh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zNZ != null)
      {
        paramVarArgs.kX(1, this.zNZ.computeSize());
        this.zNZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.zOa);
      if (this.zOb != null) {
        paramVarArgs.d(3, this.zOb);
      }
      if (this.zOc != null) {
        paramVarArgs.d(4, this.zOc);
      }
      if (this.zOd != null) {
        paramVarArgs.d(5, this.zOd);
      }
      if (this.zOe != null) {
        paramVarArgs.d(6, this.zOe);
      }
      if (this.zOf != null) {
        paramVarArgs.d(7, this.zOf);
      }
      if (this.zOg != null) {
        paramVarArgs.d(8, this.zOg);
      }
      if (this.zOh != null) {
        paramVarArgs.d(9, this.zOh);
      }
      AppMethodBeat.o(91285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zNZ == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.kW(1, this.zNZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.zOa);
      paramInt = i;
      if (this.zOb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.zOb);
      }
      i = paramInt;
      if (this.zOc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.zOc);
      }
      paramInt = i;
      if (this.zOd != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zOd);
      }
      i = paramInt;
      if (this.zOe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.zOe);
      }
      paramInt = i;
      if (this.zOf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.zOf);
      }
      i = paramInt;
      if (this.zOg != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.zOg);
      }
      paramInt = i;
      if (this.zOh != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.zOh);
      }
      AppMethodBeat.o(91285);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91285);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.zNZ = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91285);
          return 0;
        case 2: 
          localb.zOa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91285);
          return 0;
        case 3: 
          localb.zOb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 4: 
          localb.zOc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 5: 
          localb.zOd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 6: 
          localb.zOe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 7: 
          localb.zOf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 8: 
          localb.zOg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91285);
          return 0;
        }
        localb.zOh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91285);
        return 0;
      }
      AppMethodBeat.o(91285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */