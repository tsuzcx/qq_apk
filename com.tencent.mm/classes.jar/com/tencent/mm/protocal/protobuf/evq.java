package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evq
  extends com.tencent.mm.cd.a
{
  public LinkedList<evo> REB;
  public int TYJ;
  public String Uxb;
  public String Uxc;
  public crc Uxd;
  public int Uxe;
  public evp Uxf;
  public evp Uxg;
  public String desc;
  public String title;
  
  public evq()
  {
    AppMethodBeat.i(72617);
    this.REB = new LinkedList();
    AppMethodBeat.o(72617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      if (this.Uxb != null) {
        paramVarArgs.f(3, this.Uxb);
      }
      if (this.Uxc != null) {
        paramVarArgs.f(4, this.Uxc);
      }
      if (this.Uxd != null)
      {
        paramVarArgs.oE(5, this.Uxd.computeSize());
        this.Uxd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.REB);
      paramVarArgs.aY(7, this.TYJ);
      paramVarArgs.aY(8, this.Uxe);
      if (this.Uxf != null)
      {
        paramVarArgs.oE(9, this.Uxf.computeSize());
        this.Uxf.writeFields(paramVarArgs);
      }
      if (this.Uxg != null)
      {
        paramVarArgs.oE(10, this.Uxg.computeSize());
        this.Uxg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1006;
      }
    }
    label1006:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.desc);
      }
      i = paramInt;
      if (this.Uxb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uxb);
      }
      paramInt = i;
      if (this.Uxc != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uxc);
      }
      i = paramInt;
      if (this.Uxd != null) {
        i = paramInt + g.a.a.a.oD(5, this.Uxd.computeSize());
      }
      i = i + g.a.a.a.c(6, 8, this.REB) + g.a.a.b.b.a.bM(7, this.TYJ) + g.a.a.b.b.a.bM(8, this.Uxe);
      paramInt = i;
      if (this.Uxf != null) {
        paramInt = i + g.a.a.a.oD(9, this.Uxf.computeSize());
      }
      i = paramInt;
      if (this.Uxg != null) {
        i = paramInt + g.a.a.a.oD(10, this.Uxg.computeSize());
      }
      AppMethodBeat.o(72618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.REB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        evq localevq = (evq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72618);
          return -1;
        case 1: 
          localevq.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 2: 
          localevq.desc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 3: 
          localevq.Uxb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 4: 
          localevq.Uxc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crc)localObject2).parseFrom((byte[])localObject1);
            }
            localevq.Uxd = ((crc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evo)localObject2).parseFrom((byte[])localObject1);
            }
            localevq.REB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 7: 
          localevq.TYJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72618);
          return 0;
        case 8: 
          localevq.Uxe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72618);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evp)localObject2).parseFrom((byte[])localObject1);
            }
            localevq.Uxf = ((evp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new evp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((evp)localObject2).parseFrom((byte[])localObject1);
          }
          localevq.Uxg = ((evp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      AppMethodBeat.o(72618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evq
 * JD-Core Version:    0.7.0.1
 */