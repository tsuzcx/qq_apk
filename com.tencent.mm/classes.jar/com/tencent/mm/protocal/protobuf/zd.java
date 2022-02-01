package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zd
  extends ckq
{
  public String Dbi;
  public String Dbj;
  public bld Dbk;
  public LinkedList<cmf> Dbl;
  public String Dbm;
  public String Dbn;
  public String Name;
  public int mAK;
  
  public zd()
  {
    AppMethodBeat.i(32181);
    this.Dbl = new LinkedList();
    AppMethodBeat.o(32181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32182);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dbk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32182);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Dbi != null) {
        paramVarArgs.d(3, this.Dbi);
      }
      if (this.Dbj != null) {
        paramVarArgs.d(4, this.Dbj);
      }
      if (this.Dbk != null)
      {
        paramVarArgs.kX(5, this.Dbk.computeSize());
        this.Dbk.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.mAK);
      paramVarArgs.e(7, 8, this.Dbl);
      if (this.Dbm != null) {
        paramVarArgs.d(8, this.Dbm);
      }
      if (this.Dbn != null) {
        paramVarArgs.d(9, this.Dbn);
      }
      AppMethodBeat.o(32182);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1021;
      }
    }
    label1021:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.Dbi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dbi);
      }
      paramInt = i;
      if (this.Dbj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dbj);
      }
      i = paramInt;
      if (this.Dbk != null) {
        i = paramInt + f.a.a.a.kW(5, this.Dbk.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(6, this.mAK) + f.a.a.a.c(7, 8, this.Dbl);
      paramInt = i;
      if (this.Dbm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Dbm);
      }
      i = paramInt;
      if (this.Dbn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Dbn);
      }
      AppMethodBeat.o(32182);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dbl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dbk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32182);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32182);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zd localzd = (zd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32182);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 2: 
          localzd.Name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 3: 
          localzd.Dbi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 4: 
          localzd.Dbj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzd.Dbk = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 6: 
          localzd.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32182);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzd.Dbl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 8: 
          localzd.Dbm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32182);
          return 0;
        }
        localzd.Dbn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32182);
        return 0;
      }
      AppMethodBeat.o(32182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zd
 * JD-Core Version:    0.7.0.1
 */