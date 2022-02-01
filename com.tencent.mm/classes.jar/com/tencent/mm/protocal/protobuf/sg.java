package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class sg
  extends com.tencent.mm.bw.a
{
  public String Ekb;
  public String Ekc;
  public long Els;
  public String Elt;
  public String Elu;
  public String nUs;
  public String nYv;
  public String oGN;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113980);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.nUs != null) {
        paramVarArgs.d(2, this.nUs);
      }
      if (this.nYv != null) {
        paramVarArgs.d(3, this.nYv);
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
      if (this.Ekb != null) {
        paramVarArgs.d(9, this.Ekb);
      }
      if (this.Ekc != null) {
        paramVarArgs.d(10, this.Ekc);
      }
      AppMethodBeat.o(113980);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nUs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nUs);
      }
      i = paramInt;
      if (this.nYv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nYv);
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
      if (this.Ekb != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ekb);
      }
      paramInt = i;
      if (this.Ekc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ekc);
      }
      AppMethodBeat.o(113980);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113980);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sg localsg = (sg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113980);
          return -1;
        case 1: 
          localsg.title = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 2: 
          localsg.nUs = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 3: 
          localsg.nYv = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 4: 
          localsg.url = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 5: 
          localsg.Els = locala.LVo.xG();
          AppMethodBeat.o(113980);
          return 0;
        case 6: 
          localsg.Elt = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 7: 
          localsg.Elu = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 8: 
          localsg.oGN = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 9: 
          localsg.Ekb = locala.LVo.readString();
          AppMethodBeat.o(113980);
          return 0;
        }
        localsg.Ekc = locala.LVo.readString();
        AppMethodBeat.o(113980);
        return 0;
      }
      AppMethodBeat.o(113980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sg
 * JD-Core Version:    0.7.0.1
 */