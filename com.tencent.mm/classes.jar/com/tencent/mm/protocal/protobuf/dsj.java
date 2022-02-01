package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsj
  extends com.tencent.mm.bx.a
{
  public String GdZ;
  public String Gea;
  public String Geb;
  public com.tencent.mm.bx.b HFi;
  public boolean HFj;
  public LinkedList<String> HFk;
  public String HFl;
  public String MD5;
  public int xcK;
  public int xcL;
  
  public dsj()
  {
    AppMethodBeat.i(104839);
    this.HFk = new LinkedList();
    AppMethodBeat.o(104839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104840);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HFi == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(104840);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.xcL);
      paramVarArgs.aS(3, this.xcK);
      if (this.HFi != null) {
        paramVarArgs.c(4, this.HFi);
      }
      paramVarArgs.bt(5, this.HFj);
      paramVarArgs.e(6, 1, this.HFk);
      if (this.GdZ != null) {
        paramVarArgs.d(7, this.GdZ);
      }
      if (this.HFl != null) {
        paramVarArgs.d(8, this.HFl);
      }
      if (this.Geb != null) {
        paramVarArgs.d(9, this.Geb);
      }
      if (this.Gea != null) {
        paramVarArgs.d(10, this.Gea);
      }
      AppMethodBeat.o(104840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xcL) + f.a.a.b.b.a.bz(3, this.xcK);
      paramInt = i;
      if (this.HFi != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HFi);
      }
      i = paramInt + f.a.a.b.b.a.alV(5) + f.a.a.a.c(6, 1, this.HFk);
      paramInt = i;
      if (this.GdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GdZ);
      }
      i = paramInt;
      if (this.HFl != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HFl);
      }
      paramInt = i;
      if (this.Geb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Geb);
      }
      i = paramInt;
      if (this.Gea != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Gea);
      }
      AppMethodBeat.o(104840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HFk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HFi == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(104840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104840);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsj localdsj = (dsj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104840);
          return -1;
        case 1: 
          localdsj.MD5 = locala.NPN.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 2: 
          localdsj.xcL = locala.NPN.zc();
          AppMethodBeat.o(104840);
          return 0;
        case 3: 
          localdsj.xcK = locala.NPN.zc();
          AppMethodBeat.o(104840);
          return 0;
        case 4: 
          localdsj.HFi = locala.NPN.gxI();
          AppMethodBeat.o(104840);
          return 0;
        case 5: 
          localdsj.HFj = locala.NPN.grw();
          AppMethodBeat.o(104840);
          return 0;
        case 6: 
          localdsj.HFk.add(locala.NPN.readString());
          AppMethodBeat.o(104840);
          return 0;
        case 7: 
          localdsj.GdZ = locala.NPN.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 8: 
          localdsj.HFl = locala.NPN.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 9: 
          localdsj.Geb = locala.NPN.readString();
          AppMethodBeat.o(104840);
          return 0;
        }
        localdsj.Gea = locala.NPN.readString();
        AppMethodBeat.o(104840);
        return 0;
      }
      AppMethodBeat.o(104840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsj
 * JD-Core Version:    0.7.0.1
 */