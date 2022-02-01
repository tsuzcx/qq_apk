package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public v acjr;
  public c acjs;
  public boolean acjt;
  public ah acju;
  public int vhJ;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259718);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      if (this.acjr != null)
      {
        paramVarArgs.qD(2, this.acjr.computeSize());
        this.acjr.writeFields(paramVarArgs);
      }
      if (this.acjs != null)
      {
        paramVarArgs.qD(3, this.acjs.computeSize());
        this.acjs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.Idd);
      paramVarArgs.di(5, this.acjt);
      if (this.ytw != null) {
        paramVarArgs.g(6, this.ytw);
      }
      if (this.acju != null)
      {
        paramVarArgs.qD(7, this.acju.computeSize());
        this.acju.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259718);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.acjr != null) {
        paramInt = i + i.a.a.a.qC(2, this.acjr.computeSize());
      }
      i = paramInt;
      if (this.acjs != null) {
        i = paramInt + i.a.a.a.qC(3, this.acjs.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(4, this.Idd) + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ytw);
      }
      i = paramInt;
      if (this.acju != null) {
        i = paramInt + i.a.a.a.qC(7, this.acju.computeSize());
      }
      AppMethodBeat.o(259718);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259718);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      aa localaa = (aa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259718);
        return -1;
      case 1: 
        localaa.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259718);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new v();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((v)localObject2).parseFrom((byte[])localObject1);
          }
          localaa.acjr = ((v)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259718);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          localaa.acjs = ((c)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259718);
        return 0;
      case 4: 
        localaa.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259718);
        return 0;
      case 5: 
        localaa.acjt = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(259718);
        return 0;
      case 6: 
        localaa.ytw = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259718);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ah();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ah)localObject2).parseFrom((byte[])localObject1);
        }
        localaa.acju = ((ah)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259718);
      return 0;
    }
    AppMethodBeat.o(259718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.aa
 * JD-Core Version:    0.7.0.1
 */