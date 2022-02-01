package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aez
  extends com.tencent.mm.bx.a
{
  public cvr FKc;
  public String Gdd;
  public String Gde;
  public int Gdf;
  public String Gdg;
  public String nDo;
  public String ueY;
  public int ugz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKc != null)
      {
        paramVarArgs.lC(1, this.FKc.computeSize());
        this.FKc.writeFields(paramVarArgs);
      }
      if (this.ueY != null) {
        paramVarArgs.d(2, this.ueY);
      }
      if (this.Gdd != null) {
        paramVarArgs.d(3, this.Gdd);
      }
      paramVarArgs.aS(4, this.ugz);
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      if (this.Gde != null) {
        paramVarArgs.d(6, this.Gde);
      }
      paramVarArgs.aS(7, this.Gdf);
      if (this.Gdg != null) {
        paramVarArgs.d(8, this.Gdg);
      }
      AppMethodBeat.o(117866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKc == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.a.lB(1, this.FKc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ueY);
      }
      i = paramInt;
      if (this.Gdd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gdd);
      }
      i += f.a.a.b.b.a.bz(4, this.ugz);
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.nDo);
      }
      i = paramInt;
      if (this.Gde != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Gde);
      }
      i += f.a.a.b.b.a.bz(7, this.Gdf);
      paramInt = i;
      if (this.Gdg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gdg);
      }
      AppMethodBeat.o(117866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aez localaez = (aez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117866);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cvr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaez.FKc = ((cvr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117866);
          return 0;
        case 2: 
          localaez.ueY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 3: 
          localaez.Gdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 4: 
          localaez.ugz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117866);
          return 0;
        case 5: 
          localaez.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 6: 
          localaez.Gde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 7: 
          localaez.Gdf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117866);
          return 0;
        }
        localaez.Gdg = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117866);
        return 0;
      }
      AppMethodBeat.o(117866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aez
 * JD-Core Version:    0.7.0.1
 */