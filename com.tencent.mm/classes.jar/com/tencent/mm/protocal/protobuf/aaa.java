package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aaa
  extends cpx
{
  public String Euh;
  public String Eui;
  public boz Euj;
  public LinkedList<crm> Euk;
  public String Eul;
  public String Eum;
  public String Name;
  public int ncL;
  
  public aaa()
  {
    AppMethodBeat.i(32181);
    this.Euk = new LinkedList();
    AppMethodBeat.o(32181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32182);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Euj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32182);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Euh != null) {
        paramVarArgs.d(3, this.Euh);
      }
      if (this.Eui != null) {
        paramVarArgs.d(4, this.Eui);
      }
      if (this.Euj != null)
      {
        paramVarArgs.ln(5, this.Euj.computeSize());
        this.Euj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.ncL);
      paramVarArgs.e(7, 8, this.Euk);
      if (this.Eul != null) {
        paramVarArgs.d(8, this.Eul);
      }
      if (this.Eum != null) {
        paramVarArgs.d(9, this.Eum);
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
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.Euh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Euh);
      }
      paramInt = i;
      if (this.Eui != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eui);
      }
      i = paramInt;
      if (this.Euj != null) {
        i = paramInt + f.a.a.a.lm(5, this.Euj.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(6, this.ncL) + f.a.a.a.c(7, 8, this.Euk);
      paramInt = i;
      if (this.Eul != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Eul);
      }
      i = paramInt;
      if (this.Eum != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Eum);
      }
      AppMethodBeat.o(32182);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Euk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Euj == null)
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
        aaa localaaa = (aaa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32182);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaaa.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 2: 
          localaaa.Name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 3: 
          localaaa.Euh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 4: 
          localaaa.Eui = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaaa.Euj = ((boz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 6: 
          localaaa.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32182);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaaa.Euk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 8: 
          localaaa.Eul = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32182);
          return 0;
        }
        localaaa.Eum = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32182);
        return 0;
      }
      AppMethodBeat.o(32182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaa
 * JD-Core Version:    0.7.0.1
 */