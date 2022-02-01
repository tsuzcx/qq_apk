package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acj
  extends cvw
{
  public String Guh;
  public String Gui;
  public bug Guj;
  public LinkedList<cxn> Guk;
  public String Gul;
  public String Gum;
  public String Name;
  public int nID;
  
  public acj()
  {
    AppMethodBeat.i(32181);
    this.Guk = new LinkedList();
    AppMethodBeat.o(32181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32182);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Guj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32182);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Guh != null) {
        paramVarArgs.d(3, this.Guh);
      }
      if (this.Gui != null) {
        paramVarArgs.d(4, this.Gui);
      }
      if (this.Guj != null)
      {
        paramVarArgs.lJ(5, this.Guj.computeSize());
        this.Guj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.nID);
      paramVarArgs.e(7, 8, this.Guk);
      if (this.Gul != null) {
        paramVarArgs.d(8, this.Gul);
      }
      if (this.Gum != null) {
        paramVarArgs.d(9, this.Gum);
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
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.Guh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Guh);
      }
      paramInt = i;
      if (this.Gui != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gui);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.a.lI(5, this.Guj.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(6, this.nID) + f.a.a.a.c(7, 8, this.Guk);
      paramInt = i;
      if (this.Gul != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gul);
      }
      i = paramInt;
      if (this.Gum != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gum);
      }
      AppMethodBeat.o(32182);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Guk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Guj == null)
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
        acj localacj = (acj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32182);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 2: 
          localacj.Name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 3: 
          localacj.Guh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 4: 
          localacj.Gui = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bug();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bug)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacj.Guj = ((bug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 6: 
          localacj.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32182);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacj.Guk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 8: 
          localacj.Gul = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32182);
          return 0;
        }
        localacj.Gum = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32182);
        return 0;
      }
      AppMethodBeat.o(32182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acj
 * JD-Core Version:    0.7.0.1
 */