package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqh
  extends com.tencent.mm.cd.a
{
  public eaa RGh;
  public String ROQ;
  public dvh TJH;
  public dhr Ufm;
  public clc UsJ;
  public LinkedList<erh> UsK;
  public LinkedList<erh> UsL;
  public clc UsM;
  public dzz UsN;
  
  public eqh()
  {
    AppMethodBeat.i(91707);
    this.UsK = new LinkedList();
    this.UsL = new LinkedList();
    AppMethodBeat.o(91707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UsJ != null)
      {
        paramVarArgs.oE(1, this.UsJ.computeSize());
        this.UsJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.UsK);
      paramVarArgs.e(3, 8, this.UsL);
      if (this.UsM != null)
      {
        paramVarArgs.oE(4, this.UsM.computeSize());
        this.UsM.writeFields(paramVarArgs);
      }
      if (this.TJH != null)
      {
        paramVarArgs.oE(5, this.TJH.computeSize());
        this.TJH.writeFields(paramVarArgs);
      }
      if (this.ROQ != null) {
        paramVarArgs.f(6, this.ROQ);
      }
      if (this.Ufm != null)
      {
        paramVarArgs.oE(7, this.Ufm.computeSize());
        this.Ufm.writeFields(paramVarArgs);
      }
      if (this.RGh != null)
      {
        paramVarArgs.oE(8, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      if (this.UsN != null)
      {
        paramVarArgs.oE(9, this.UsN.computeSize());
        this.UsN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UsJ == null) {
        break label1250;
      }
    }
    label1250:
    for (paramInt = g.a.a.a.oD(1, this.UsJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.UsK) + g.a.a.a.c(3, 8, this.UsL);
      paramInt = i;
      if (this.UsM != null) {
        paramInt = i + g.a.a.a.oD(4, this.UsM.computeSize());
      }
      i = paramInt;
      if (this.TJH != null) {
        i = paramInt + g.a.a.a.oD(5, this.TJH.computeSize());
      }
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ROQ);
      }
      i = paramInt;
      if (this.Ufm != null) {
        i = paramInt + g.a.a.a.oD(7, this.Ufm.computeSize());
      }
      paramInt = i;
      if (this.RGh != null) {
        paramInt = i + g.a.a.a.oD(8, this.RGh.computeSize());
      }
      i = paramInt;
      if (this.UsN != null) {
        i = paramInt + g.a.a.a.oD(9, this.UsN.computeSize());
      }
      AppMethodBeat.o(91708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UsK.clear();
        this.UsL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqh localeqh = (eqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91708);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clc)localObject2).parseFrom((byte[])localObject1);
            }
            localeqh.UsJ = ((clc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localeqh.UsK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localeqh.UsL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clc)localObject2).parseFrom((byte[])localObject1);
            }
            localeqh.UsM = ((clc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvh)localObject2).parseFrom((byte[])localObject1);
            }
            localeqh.TJH = ((dvh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 6: 
          localeqh.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91708);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhr)localObject2).parseFrom((byte[])localObject1);
            }
            localeqh.Ufm = ((dhr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaa)localObject2).parseFrom((byte[])localObject1);
            }
            localeqh.RGh = ((eaa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91708);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzz)localObject2).parseFrom((byte[])localObject1);
          }
          localeqh.UsN = ((dzz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91708);
        return 0;
      }
      AppMethodBeat.o(91708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqh
 * JD-Core Version:    0.7.0.1
 */