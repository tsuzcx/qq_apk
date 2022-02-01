package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dql
  extends com.tencent.mm.bx.a
{
  public String CBS;
  public String EGg;
  public String EGh;
  public String EGi;
  public String fVv;
  public String fVw;
  public String fVx;
  public String fVy;
  public String mAU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBS != null) {
        paramVarArgs.d(1, this.CBS);
      }
      if (this.fVw != null) {
        paramVarArgs.d(2, this.fVw);
      }
      if (this.fVv != null) {
        paramVarArgs.d(3, this.fVv);
      }
      if (this.mAU != null) {
        paramVarArgs.d(4, this.mAU);
      }
      if (this.EGg != null) {
        paramVarArgs.d(5, this.EGg);
      }
      if (this.fVx != null) {
        paramVarArgs.d(6, this.fVx);
      }
      if (this.fVy != null) {
        paramVarArgs.d(7, this.fVy);
      }
      if (this.EGh != null) {
        paramVarArgs.d(8, this.EGh);
      }
      if (this.EGi != null) {
        paramVarArgs.d(9, this.EGi);
      }
      AppMethodBeat.o(116822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CBS == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.b.b.a.e(1, this.CBS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fVw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fVw);
      }
      i = paramInt;
      if (this.fVv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fVv);
      }
      paramInt = i;
      if (this.mAU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mAU);
      }
      i = paramInt;
      if (this.EGg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EGg);
      }
      paramInt = i;
      if (this.fVx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fVx);
      }
      i = paramInt;
      if (this.fVy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.fVy);
      }
      paramInt = i;
      if (this.EGh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EGh);
      }
      i = paramInt;
      if (this.EGi != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EGi);
      }
      AppMethodBeat.o(116822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116822);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dql localdql = (dql)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116822);
          return -1;
        case 1: 
          localdql.CBS = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 2: 
          localdql.fVw = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 3: 
          localdql.fVv = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 4: 
          localdql.mAU = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 5: 
          localdql.EGg = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 6: 
          localdql.fVx = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 7: 
          localdql.fVy = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 8: 
          localdql.EGh = locala.KhF.readString();
          AppMethodBeat.o(116822);
          return 0;
        }
        localdql.EGi = locala.KhF.readString();
        AppMethodBeat.o(116822);
        return 0;
      }
      AppMethodBeat.o(116822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dql
 * JD-Core Version:    0.7.0.1
 */