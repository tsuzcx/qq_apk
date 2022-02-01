package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cng
  extends com.tencent.mm.bw.a
{
  public String FAr;
  public LinkedList<dds> FAs;
  public String FAt;
  public String FAu;
  public String FAv;
  public cne FAw;
  public String description;
  public String hhr;
  public String hhs;
  public String hht;
  public int nWg;
  public String title;
  
  public cng()
  {
    AppMethodBeat.i(168759);
    this.FAs = new LinkedList();
    AppMethodBeat.o(168759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.hhs != null) {
        paramVarArgs.d(2, this.hhs);
      }
      if (this.hht != null) {
        paramVarArgs.d(3, this.hht);
      }
      if (this.description != null) {
        paramVarArgs.d(4, this.description);
      }
      if (this.FAr != null) {
        paramVarArgs.d(9, this.FAr);
      }
      paramVarArgs.e(10, 8, this.FAs);
      paramVarArgs.aR(11, this.nWg);
      if (this.FAt != null) {
        paramVarArgs.d(12, this.FAt);
      }
      if (this.FAu != null) {
        paramVarArgs.d(13, this.FAu);
      }
      if (this.FAv != null) {
        paramVarArgs.d(14, this.FAv);
      }
      if (this.hhr != null) {
        paramVarArgs.d(15, this.hhr);
      }
      if (this.FAw != null)
      {
        paramVarArgs.ln(16, this.FAw.computeSize());
        this.FAw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hhs);
      }
      i = paramInt;
      if (this.hht != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hht);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.description);
      }
      i = paramInt;
      if (this.FAr != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FAr);
      }
      i = i + f.a.a.a.c(10, 8, this.FAs) + f.a.a.b.b.a.bx(11, this.nWg);
      paramInt = i;
      if (this.FAt != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FAt);
      }
      i = paramInt;
      if (this.FAu != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FAu);
      }
      paramInt = i;
      if (this.FAv != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FAv);
      }
      i = paramInt;
      if (this.hhr != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.hhr);
      }
      paramInt = i;
      if (this.FAw != null) {
        paramInt = i + f.a.a.a.lm(16, this.FAw.computeSize());
      }
      AppMethodBeat.o(168760);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cng localcng = (cng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(168760);
          return -1;
        case 1: 
          localcng.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 2: 
          localcng.hhs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 3: 
          localcng.hht = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 4: 
          localcng.description = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 9: 
          localcng.FAr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcng.FAs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 11: 
          localcng.nWg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168760);
          return 0;
        case 12: 
          localcng.FAt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 13: 
          localcng.FAu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 14: 
          localcng.FAv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 15: 
          localcng.hhr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168760);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cne();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cne)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcng.FAw = ((cne)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      AppMethodBeat.o(168760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cng
 * JD-Core Version:    0.7.0.1
 */