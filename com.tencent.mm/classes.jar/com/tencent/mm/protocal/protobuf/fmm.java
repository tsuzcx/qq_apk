package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fmm
  extends com.tencent.mm.bx.a
{
  public int CMB;
  public int NZt;
  public amh NZv;
  public fxy Zbl;
  public String mAD;
  public String text;
  public int textColor;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140931);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.text == null)
      {
        paramVarArgs = new b("Not all required fields were included: text");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.Zbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140931);
        throw paramVarArgs;
      }
      if (this.text != null) {
        paramVarArgs.g(1, this.text);
      }
      paramVarArgs.bS(2, this.textColor);
      paramVarArgs.bS(3, this.NZt);
      if (this.Zbl != null)
      {
        paramVarArgs.qD(4, this.Zbl.computeSize());
        this.Zbl.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.CMB);
      if (this.NZv != null)
      {
        paramVarArgs.qD(6, this.NZv.computeSize());
        this.NZv.writeFields(paramVarArgs);
      }
      if (this.mAD != null) {
        paramVarArgs.g(7, this.mAD);
      }
      AppMethodBeat.o(140931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = i.a.a.b.b.a.h(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.textColor) + i.a.a.b.b.a.cJ(3, this.NZt);
      paramInt = i;
      if (this.Zbl != null) {
        paramInt = i + i.a.a.a.qC(4, this.Zbl.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.CMB);
      paramInt = i;
      if (this.NZv != null) {
        paramInt = i + i.a.a.a.qC(6, this.NZv.computeSize());
      }
      i = paramInt;
      if (this.mAD != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.mAD);
      }
      AppMethodBeat.o(140931);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.text == null)
        {
          paramVarArgs = new b("Not all required fields were included: text");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        if (this.Zbl == null)
        {
          paramVarArgs = new b("Not all required fields were included: matrix");
          AppMethodBeat.o(140931);
          throw paramVarArgs;
        }
        AppMethodBeat.o(140931);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fmm localfmm = (fmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(140931);
          return -1;
        case 1: 
          localfmm.text = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(140931);
          return 0;
        case 2: 
          localfmm.textColor = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(140931);
          return 0;
        case 3: 
          localfmm.NZt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(140931);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxy)localObject2).parseFrom((byte[])localObject1);
            }
            localfmm.Zbl = ((fxy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        case 5: 
          localfmm.CMB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(140931);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amh)localObject2).parseFrom((byte[])localObject1);
            }
            localfmm.NZv = ((amh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(140931);
          return 0;
        }
        localfmm.mAD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(140931);
        return 0;
      }
      AppMethodBeat.o(140931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmm
 * JD-Core Version:    0.7.0.1
 */