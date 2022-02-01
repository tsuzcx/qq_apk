package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqs
  extends com.tencent.mm.bw.a
{
  public int EJL;
  public String EJM;
  public String EJN;
  public int Eae;
  public String hOf;
  public com.tencent.mm.bw.b ncy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.ncy == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.EJN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EventInfo");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.hOf != null) {
        paramVarArgs.d(1, this.hOf);
      }
      paramVarArgs.aR(2, this.Eae);
      paramVarArgs.aR(3, this.EJL);
      if (this.ncy != null) {
        paramVarArgs.c(4, this.ncy);
      }
      if (this.EJM != null) {
        paramVarArgs.d(5, this.EJM);
      }
      if (this.EJN != null) {
        paramVarArgs.d(6, this.EJN);
      }
      AppMethodBeat.o(50086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hOf == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.hOf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Eae) + f.a.a.b.b.a.bx(3, this.EJL);
      paramInt = i;
      if (this.ncy != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.ncy);
      }
      i = paramInt;
      if (this.EJM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EJM);
      }
      paramInt = i;
      if (this.EJN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EJN);
      }
      AppMethodBeat.o(50086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.hOf == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.ncy == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.EJN == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: EventInfo");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50086);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aqs localaqs = (aqs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50086);
          return -1;
        case 1: 
          localaqs.hOf = locala.LVo.readString();
          AppMethodBeat.o(50086);
          return 0;
        case 2: 
          localaqs.Eae = locala.LVo.xF();
          AppMethodBeat.o(50086);
          return 0;
        case 3: 
          localaqs.EJL = locala.LVo.xF();
          AppMethodBeat.o(50086);
          return 0;
        case 4: 
          localaqs.ncy = locala.LVo.gfk();
          AppMethodBeat.o(50086);
          return 0;
        case 5: 
          localaqs.EJM = locala.LVo.readString();
          AppMethodBeat.o(50086);
          return 0;
        }
        localaqs.EJN = locala.LVo.readString();
        AppMethodBeat.o(50086);
        return 0;
      }
      AppMethodBeat.o(50086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqs
 * JD-Core Version:    0.7.0.1
 */