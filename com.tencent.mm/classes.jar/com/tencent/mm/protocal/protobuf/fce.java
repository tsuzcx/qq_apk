package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fce
  extends com.tencent.mm.bx.a
{
  public String Edn;
  public String abBI;
  public String abBJ;
  public String app_id;
  public long mMJ;
  public long object_id;
  public String request_id;
  public int scene;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259096);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.g(1, this.app_id);
      }
      if (this.abBI != null) {
        paramVarArgs.g(2, this.abBI);
      }
      paramVarArgs.bv(3, this.object_id);
      paramVarArgs.bv(4, this.mMJ);
      if (this.abBJ != null) {
        paramVarArgs.g(5, this.abBJ);
      }
      if (this.session_id != null) {
        paramVarArgs.g(6, this.session_id);
      }
      if (this.request_id != null) {
        paramVarArgs.g(7, this.request_id);
      }
      if (this.Edn != null) {
        paramVarArgs.g(8, this.Edn);
      }
      paramVarArgs.bS(9, this.scene);
      AppMethodBeat.o(259096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = i.a.a.b.b.a.h(1, this.app_id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abBI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abBI);
      }
      i = i + i.a.a.b.b.a.q(3, this.object_id) + i.a.a.b.b.a.q(4, this.mMJ);
      paramInt = i;
      if (this.abBJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abBJ);
      }
      i = paramInt;
      if (this.session_id != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.session_id);
      }
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.request_id);
      }
      i = paramInt;
      if (this.Edn != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Edn);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.scene);
      AppMethodBeat.o(259096);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259096);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fce localfce = (fce)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259096);
          return -1;
        case 1: 
          localfce.app_id = locala.ajGk.readString();
          AppMethodBeat.o(259096);
          return 0;
        case 2: 
          localfce.abBI = locala.ajGk.readString();
          AppMethodBeat.o(259096);
          return 0;
        case 3: 
          localfce.object_id = locala.ajGk.aaw();
          AppMethodBeat.o(259096);
          return 0;
        case 4: 
          localfce.mMJ = locala.ajGk.aaw();
          AppMethodBeat.o(259096);
          return 0;
        case 5: 
          localfce.abBJ = locala.ajGk.readString();
          AppMethodBeat.o(259096);
          return 0;
        case 6: 
          localfce.session_id = locala.ajGk.readString();
          AppMethodBeat.o(259096);
          return 0;
        case 7: 
          localfce.request_id = locala.ajGk.readString();
          AppMethodBeat.o(259096);
          return 0;
        case 8: 
          localfce.Edn = locala.ajGk.readString();
          AppMethodBeat.o(259096);
          return 0;
        }
        localfce.scene = locala.ajGk.aar();
        AppMethodBeat.o(259096);
        return 0;
      }
      AppMethodBeat.o(259096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fce
 * JD-Core Version:    0.7.0.1
 */