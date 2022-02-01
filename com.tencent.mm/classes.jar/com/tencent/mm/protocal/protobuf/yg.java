package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yg
  extends com.tencent.mm.bw.a
{
  public String Ekb;
  public String Ekc;
  public long Els;
  public String Elt;
  public String Elu;
  public bhz ErU;
  public String nUs;
  public String nUt;
  public String oGN;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.nUs != null) {
        paramVarArgs.d(2, this.nUs);
      }
      if (this.nUt != null) {
        paramVarArgs.d(3, this.nUt);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.aO(5, this.Els);
      if (this.Elt != null) {
        paramVarArgs.d(6, this.Elt);
      }
      if (this.Elu != null) {
        paramVarArgs.d(7, this.Elu);
      }
      if (this.oGN != null) {
        paramVarArgs.d(8, this.oGN);
      }
      if (this.ErU != null)
      {
        paramVarArgs.ln(9, this.ErU.computeSize());
        this.ErU.writeFields(paramVarArgs);
      }
      if (this.Ekb != null) {
        paramVarArgs.d(10, this.Ekb);
      }
      if (this.Ekc != null) {
        paramVarArgs.d(11, this.Ekc);
      }
      AppMethodBeat.o(113985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nUs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nUs);
      }
      i = paramInt;
      if (this.nUt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nUt);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.Els);
      paramInt = i;
      if (this.Elt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Elt);
      }
      i = paramInt;
      if (this.Elu != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Elu);
      }
      paramInt = i;
      if (this.oGN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.oGN);
      }
      i = paramInt;
      if (this.ErU != null) {
        i = paramInt + f.a.a.a.lm(9, this.ErU.computeSize());
      }
      paramInt = i;
      if (this.Ekb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ekb);
      }
      i = paramInt;
      if (this.Ekc != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Ekc);
      }
      AppMethodBeat.o(113985);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yg localyg = (yg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113985);
          return -1;
        case 1: 
          localyg.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 2: 
          localyg.nUs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 3: 
          localyg.nUt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 4: 
          localyg.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 5: 
          localyg.Els = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(113985);
          return 0;
        case 6: 
          localyg.Elt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 7: 
          localyg.Elu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 8: 
          localyg.oGN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyg.ErU = ((bhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113985);
          return 0;
        case 10: 
          localyg.Ekb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113985);
          return 0;
        }
        localyg.Ekc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113985);
        return 0;
      }
      AppMethodBeat.o(113985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yg
 * JD-Core Version:    0.7.0.1
 */