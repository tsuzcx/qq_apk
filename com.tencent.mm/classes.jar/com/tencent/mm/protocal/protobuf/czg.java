package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czg
  extends com.tencent.mm.bx.a
{
  public jx aaEg;
  public uy aaEh;
  public dog aaEi;
  public fhy aaEj;
  public eur aaEk;
  public ady aaEl;
  public asn aaEm;
  public cax aaEn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116471);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaEg != null)
      {
        paramVarArgs.qD(1, this.aaEg.computeSize());
        this.aaEg.writeFields(paramVarArgs);
      }
      if (this.aaEh != null)
      {
        paramVarArgs.qD(2, this.aaEh.computeSize());
        this.aaEh.writeFields(paramVarArgs);
      }
      if (this.aaEi != null)
      {
        paramVarArgs.qD(3, this.aaEi.computeSize());
        this.aaEi.writeFields(paramVarArgs);
      }
      if (this.aaEj != null)
      {
        paramVarArgs.qD(4, this.aaEj.computeSize());
        this.aaEj.writeFields(paramVarArgs);
      }
      if (this.aaEk != null)
      {
        paramVarArgs.qD(6, this.aaEk.computeSize());
        this.aaEk.writeFields(paramVarArgs);
      }
      if (this.aaEl != null)
      {
        paramVarArgs.qD(7, this.aaEl.computeSize());
        this.aaEl.writeFields(paramVarArgs);
      }
      if (this.aaEm != null)
      {
        paramVarArgs.qD(8, this.aaEm.computeSize());
        this.aaEm.writeFields(paramVarArgs);
      }
      if (this.aaEn != null)
      {
        paramVarArgs.qD(9, this.aaEn.computeSize());
        this.aaEn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaEg == null) {
        break label1222;
      }
    }
    label1222:
    for (int i = i.a.a.a.qC(1, this.aaEg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaEh != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaEh.computeSize());
      }
      i = paramInt;
      if (this.aaEi != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaEi.computeSize());
      }
      paramInt = i;
      if (this.aaEj != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaEj.computeSize());
      }
      i = paramInt;
      if (this.aaEk != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaEk.computeSize());
      }
      paramInt = i;
      if (this.aaEl != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaEl.computeSize());
      }
      i = paramInt;
      if (this.aaEm != null) {
        i = paramInt + i.a.a.a.qC(8, this.aaEm.computeSize());
      }
      paramInt = i;
      if (this.aaEn != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaEn.computeSize());
      }
      AppMethodBeat.o(116471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        czg localczg = (czg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(116471);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jx)localObject2).parseFrom((byte[])localObject1);
            }
            localczg.aaEg = ((jx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uy)localObject2).parseFrom((byte[])localObject1);
            }
            localczg.aaEh = ((uy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dog();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dog)localObject2).parseFrom((byte[])localObject1);
            }
            localczg.aaEi = ((dog)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhy)localObject2).parseFrom((byte[])localObject1);
            }
            localczg.aaEj = ((fhy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eur)localObject2).parseFrom((byte[])localObject1);
            }
            localczg.aaEk = ((eur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ady();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ady)localObject2).parseFrom((byte[])localObject1);
            }
            localczg.aaEl = ((ady)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asn)localObject2).parseFrom((byte[])localObject1);
            }
            localczg.aaEm = ((asn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cax();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cax)localObject2).parseFrom((byte[])localObject1);
          }
          localczg.aaEn = ((cax)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      AppMethodBeat.o(116471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czg
 * JD-Core Version:    0.7.0.1
 */