package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dun
  extends com.tencent.mm.bw.a
{
  public int HoF;
  public LinkedList<duo> Iag;
  public String Iah;
  public int Iai;
  public int apptype;
  public String dwb;
  public String hDU;
  public String oIr;
  
  public dun()
  {
    AppMethodBeat.i(74672);
    this.Iag = new LinkedList();
    AppMethodBeat.o(74672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.hDU != null) {
        paramVarArgs.d(2, this.hDU);
      }
      paramVarArgs.aS(3, this.apptype);
      paramVarArgs.e(4, 8, this.Iag);
      paramVarArgs.aS(5, this.HoF);
      if (this.Iah != null) {
        paramVarArgs.d(6, this.Iah);
      }
      if (this.oIr != null) {
        paramVarArgs.d(7, this.oIr);
      }
      paramVarArgs.aS(8, this.Iai);
      AppMethodBeat.o(74673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hDU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hDU);
      }
      i = i + f.a.a.b.b.a.bz(3, this.apptype) + f.a.a.a.c(4, 8, this.Iag) + f.a.a.b.b.a.bz(5, this.HoF);
      paramInt = i;
      if (this.Iah != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Iah);
      }
      i = paramInt;
      if (this.oIr != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.oIr);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.Iai);
      AppMethodBeat.o(74673);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Iag.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(74673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dun localdun = (dun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74673);
          return -1;
        case 1: 
          localdun.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 2: 
          localdun.hDU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 3: 
          localdun.apptype = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74673);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((duo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdun.Iag.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74673);
          return 0;
        case 5: 
          localdun.HoF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74673);
          return 0;
        case 6: 
          localdun.Iah = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 7: 
          localdun.oIr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(74673);
          return 0;
        }
        localdun.Iai = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(74673);
        return 0;
      }
      AppMethodBeat.o(74673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dun
 * JD-Core Version:    0.7.0.1
 */