package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahc
  extends com.tencent.mm.bw.a
{
  public String EBu;
  public LinkedList<String> EBv;
  public String appId;
  public String cYF;
  public String desc;
  public String dng;
  public ahn dsQ;
  public String title;
  public int type;
  
  public ahc()
  {
    AppMethodBeat.i(127463);
    this.EBv = new LinkedList();
    AppMethodBeat.o(127463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.dng != null) {
        paramVarArgs.d(3, this.dng);
      }
      if (this.EBu != null) {
        paramVarArgs.d(4, this.EBu);
      }
      if (this.appId != null) {
        paramVarArgs.d(5, this.appId);
      }
      if (this.cYF != null) {
        paramVarArgs.d(6, this.cYF);
      }
      paramVarArgs.e(7, 1, this.EBv);
      paramVarArgs.aR(8, this.type);
      if (this.dsQ != null)
      {
        paramVarArgs.ln(9, this.dsQ.computeSize());
        this.dsQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.dng != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dng);
      }
      paramInt = i;
      if (this.EBu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EBu);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.appId);
      }
      paramInt = i;
      if (this.cYF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.cYF);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.EBv) + f.a.a.b.b.a.bx(8, this.type);
      paramInt = i;
      if (this.dsQ != null) {
        paramInt = i + f.a.a.a.lm(9, this.dsQ.computeSize());
      }
      AppMethodBeat.o(127464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EBv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ahc localahc = (ahc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127464);
          return -1;
        case 1: 
          localahc.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 2: 
          localahc.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 3: 
          localahc.dng = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 4: 
          localahc.EBu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 5: 
          localahc.appId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 6: 
          localahc.cYF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 7: 
          localahc.EBv.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(127464);
          return 0;
        case 8: 
          localahc.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127464);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahc.dsQ = ((ahn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      AppMethodBeat.o(127464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahc
 * JD-Core Version:    0.7.0.1
 */