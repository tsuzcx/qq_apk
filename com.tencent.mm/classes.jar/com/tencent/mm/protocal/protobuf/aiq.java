package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aiq
  extends com.tencent.mm.bw.a
{
  public int FNv;
  public LinkedList<om> Gal;
  public String Gaq;
  public String Gau;
  public LinkedList<String> Gcm;
  public int Gcn;
  public long Gcv;
  public String Gys;
  public String Gyt;
  public String Gyu;
  public String Gyv;
  public String Gyw;
  
  public aiq()
  {
    AppMethodBeat.i(188950);
    this.Gal = new LinkedList();
    this.Gcm = new LinkedList();
    AppMethodBeat.o(188950);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188951);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gys != null) {
        paramVarArgs.d(1, this.Gys);
      }
      if (this.Gyt != null) {
        paramVarArgs.d(2, this.Gyt);
      }
      paramVarArgs.aZ(3, this.Gcv);
      paramVarArgs.e(4, 8, this.Gal);
      paramVarArgs.aS(5, this.FNv);
      if (this.Gyu != null) {
        paramVarArgs.d(6, this.Gyu);
      }
      if (this.Gaq != null) {
        paramVarArgs.d(7, this.Gaq);
      }
      if (this.Gau != null) {
        paramVarArgs.d(8, this.Gau);
      }
      paramVarArgs.e(9, 1, this.Gcm);
      paramVarArgs.aS(10, this.Gcn);
      if (this.Gyv != null) {
        paramVarArgs.d(11, this.Gyv);
      }
      if (this.Gyw != null) {
        paramVarArgs.d(12, this.Gyw);
      }
      AppMethodBeat.o(188951);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gys == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gys) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gyt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gyt);
      }
      i = i + f.a.a.b.b.a.p(3, this.Gcv) + f.a.a.a.c(4, 8, this.Gal) + f.a.a.b.b.a.bz(5, this.FNv);
      paramInt = i;
      if (this.Gyu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gyu);
      }
      i = paramInt;
      if (this.Gaq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gaq);
      }
      paramInt = i;
      if (this.Gau != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gau);
      }
      i = paramInt + f.a.a.a.c(9, 1, this.Gcm) + f.a.a.b.b.a.bz(10, this.Gcn);
      paramInt = i;
      if (this.Gyv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Gyv);
      }
      i = paramInt;
      if (this.Gyw != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gyw);
      }
      AppMethodBeat.o(188951);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gal.clear();
        this.Gcm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188951);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aiq localaiq = (aiq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188951);
          return -1;
        case 1: 
          localaiq.Gys = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188951);
          return 0;
        case 2: 
          localaiq.Gyt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188951);
          return 0;
        case 3: 
          localaiq.Gcv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188951);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new om();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((om)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiq.Gal.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188951);
          return 0;
        case 5: 
          localaiq.FNv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188951);
          return 0;
        case 6: 
          localaiq.Gyu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188951);
          return 0;
        case 7: 
          localaiq.Gaq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188951);
          return 0;
        case 8: 
          localaiq.Gau = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188951);
          return 0;
        case 9: 
          localaiq.Gcm.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(188951);
          return 0;
        case 10: 
          localaiq.Gcn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188951);
          return 0;
        case 11: 
          localaiq.Gyv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188951);
          return 0;
        }
        localaiq.Gyw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188951);
        return 0;
      }
      AppMethodBeat.o(188951);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiq
 * JD-Core Version:    0.7.0.1
 */