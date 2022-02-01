package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gdd
  extends com.tencent.mm.bx.a
{
  public gol acaV;
  public gol acaW;
  public gol acaX;
  public gol acaY;
  public gol acaZ;
  public gol acba;
  public gol acbb;
  public gol acbc;
  public gol acbd;
  public gol acbe;
  public gol acbf;
  public gol acbg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155542);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaV != null)
      {
        paramVarArgs.qD(1, this.acaV.computeSize());
        this.acaV.writeFields(paramVarArgs);
      }
      if (this.acaW != null)
      {
        paramVarArgs.qD(2, this.acaW.computeSize());
        this.acaW.writeFields(paramVarArgs);
      }
      if (this.acaX != null)
      {
        paramVarArgs.qD(3, this.acaX.computeSize());
        this.acaX.writeFields(paramVarArgs);
      }
      if (this.acaY != null)
      {
        paramVarArgs.qD(4, this.acaY.computeSize());
        this.acaY.writeFields(paramVarArgs);
      }
      if (this.acaZ != null)
      {
        paramVarArgs.qD(5, this.acaZ.computeSize());
        this.acaZ.writeFields(paramVarArgs);
      }
      if (this.acba != null)
      {
        paramVarArgs.qD(6, this.acba.computeSize());
        this.acba.writeFields(paramVarArgs);
      }
      if (this.acbb != null)
      {
        paramVarArgs.qD(7, this.acbb.computeSize());
        this.acbb.writeFields(paramVarArgs);
      }
      if (this.acbc != null)
      {
        paramVarArgs.qD(8, this.acbc.computeSize());
        this.acbc.writeFields(paramVarArgs);
      }
      if (this.acbd != null)
      {
        paramVarArgs.qD(9, this.acbd.computeSize());
        this.acbd.writeFields(paramVarArgs);
      }
      if (this.acbe != null)
      {
        paramVarArgs.qD(10, this.acbe.computeSize());
        this.acbe.writeFields(paramVarArgs);
      }
      if (this.acbf != null)
      {
        paramVarArgs.qD(11, this.acbf.computeSize());
        this.acbf.writeFields(paramVarArgs);
      }
      if (this.acbg != null)
      {
        paramVarArgs.qD(12, this.acbg.computeSize());
        this.acbg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaV == null) {
        break label1750;
      }
    }
    label1750:
    for (int i = i.a.a.a.qC(1, this.acaV.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acaW != null) {
        paramInt = i + i.a.a.a.qC(2, this.acaW.computeSize());
      }
      i = paramInt;
      if (this.acaX != null) {
        i = paramInt + i.a.a.a.qC(3, this.acaX.computeSize());
      }
      paramInt = i;
      if (this.acaY != null) {
        paramInt = i + i.a.a.a.qC(4, this.acaY.computeSize());
      }
      i = paramInt;
      if (this.acaZ != null) {
        i = paramInt + i.a.a.a.qC(5, this.acaZ.computeSize());
      }
      paramInt = i;
      if (this.acba != null) {
        paramInt = i + i.a.a.a.qC(6, this.acba.computeSize());
      }
      i = paramInt;
      if (this.acbb != null) {
        i = paramInt + i.a.a.a.qC(7, this.acbb.computeSize());
      }
      paramInt = i;
      if (this.acbc != null) {
        paramInt = i + i.a.a.a.qC(8, this.acbc.computeSize());
      }
      i = paramInt;
      if (this.acbd != null) {
        i = paramInt + i.a.a.a.qC(9, this.acbd.computeSize());
      }
      paramInt = i;
      if (this.acbe != null) {
        paramInt = i + i.a.a.a.qC(10, this.acbe.computeSize());
      }
      i = paramInt;
      if (this.acbf != null) {
        i = paramInt + i.a.a.a.qC(11, this.acbf.computeSize());
      }
      paramInt = i;
      if (this.acbg != null) {
        paramInt = i + i.a.a.a.qC(12, this.acbg.computeSize());
      }
      AppMethodBeat.o(155542);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gdd localgdd = (gdd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        gol localgol;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155542);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acaV = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acaW = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acaX = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acaY = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acaZ = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acba = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acbb = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acbc = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acbd = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acbe = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localgdd.acbf = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(155542);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localgdd.acbg = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(155542);
        return 0;
      }
      AppMethodBeat.o(155542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdd
 * JD-Core Version:    0.7.0.1
 */