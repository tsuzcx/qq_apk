package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cat
  extends dyy
{
  public eez TiW;
  public foe TiX;
  public fow TiY;
  public aov TiZ;
  public fog Tja;
  public fpg Tjb;
  public fpi Tjc;
  public String Tjd;
  public String Tje;
  public LinkedList<fpi> Tjf;
  
  public cat()
  {
    AppMethodBeat.i(191906);
    this.Tjf = new LinkedList();
    AppMethodBeat.o(191906);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153276);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153276);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TiW != null)
      {
        paramVarArgs.oE(2, this.TiW.computeSize());
        this.TiW.writeFields(paramVarArgs);
      }
      if (this.TiX != null)
      {
        paramVarArgs.oE(3, this.TiX.computeSize());
        this.TiX.writeFields(paramVarArgs);
      }
      if (this.TiY != null)
      {
        paramVarArgs.oE(4, this.TiY.computeSize());
        this.TiY.writeFields(paramVarArgs);
      }
      if (this.TiZ != null)
      {
        paramVarArgs.oE(5, this.TiZ.computeSize());
        this.TiZ.writeFields(paramVarArgs);
      }
      if (this.Tja != null)
      {
        paramVarArgs.oE(6, this.Tja.computeSize());
        this.Tja.writeFields(paramVarArgs);
      }
      if (this.Tjb != null)
      {
        paramVarArgs.oE(7, this.Tjb.computeSize());
        this.Tjb.writeFields(paramVarArgs);
      }
      if (this.Tjc != null)
      {
        paramVarArgs.oE(8, this.Tjc.computeSize());
        this.Tjc.writeFields(paramVarArgs);
      }
      if (this.Tjd != null) {
        paramVarArgs.f(10, this.Tjd);
      }
      if (this.Tje != null) {
        paramVarArgs.f(11, this.Tje);
      }
      paramVarArgs.e(12, 8, this.Tjf);
      AppMethodBeat.o(153276);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1516;
      }
    }
    label1516:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TiW != null) {
        paramInt = i + g.a.a.a.oD(2, this.TiW.computeSize());
      }
      i = paramInt;
      if (this.TiX != null) {
        i = paramInt + g.a.a.a.oD(3, this.TiX.computeSize());
      }
      paramInt = i;
      if (this.TiY != null) {
        paramInt = i + g.a.a.a.oD(4, this.TiY.computeSize());
      }
      i = paramInt;
      if (this.TiZ != null) {
        i = paramInt + g.a.a.a.oD(5, this.TiZ.computeSize());
      }
      paramInt = i;
      if (this.Tja != null) {
        paramInt = i + g.a.a.a.oD(6, this.Tja.computeSize());
      }
      i = paramInt;
      if (this.Tjb != null) {
        i = paramInt + g.a.a.a.oD(7, this.Tjb.computeSize());
      }
      paramInt = i;
      if (this.Tjc != null) {
        paramInt = i + g.a.a.a.oD(8, this.Tjc.computeSize());
      }
      i = paramInt;
      if (this.Tjd != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Tjd);
      }
      paramInt = i;
      if (this.Tje != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Tje);
      }
      i = g.a.a.a.c(12, 8, this.Tjf);
      AppMethodBeat.o(153276);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tjf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153276);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cat localcat = (cat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(153276);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eez)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.TiW = ((eez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foe)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.TiX = ((foe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fow();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fow)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.TiY = ((fow)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aov();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aov)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.TiZ = ((aov)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fog();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fog)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.Tja = ((fog)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpg)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.Tjb = ((fpg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fpi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fpi)localObject2).parseFrom((byte[])localObject1);
            }
            localcat.Tjc = ((fpi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153276);
          return 0;
        case 10: 
          localcat.Tjd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153276);
          return 0;
        case 11: 
          localcat.Tje = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153276);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fpi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fpi)localObject2).parseFrom((byte[])localObject1);
          }
          localcat.Tjf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153276);
        return 0;
      }
      AppMethodBeat.o(153276);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cat
 * JD-Core Version:    0.7.0.1
 */