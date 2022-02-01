package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blp
  extends cvc
{
  public int FKN;
  public String GDK;
  public int GDN;
  public int GFE;
  public boolean GFF;
  public chc GFG;
  public String GFH;
  public LinkedList<cbg> GFI;
  public int GFJ;
  public boolean GFK;
  public boolean GFL;
  public String duW;
  public String lJC;
  public String path;
  public int scene;
  public int type;
  public String username;
  
  public blp()
  {
    AppMethodBeat.i(123586);
    this.GFF = false;
    this.GFI = new LinkedList();
    AppMethodBeat.o(123586);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.type);
      if (this.duW != null) {
        paramVarArgs.d(3, this.duW);
      }
      paramVarArgs.aS(4, this.FKN);
      if (this.lJC != null) {
        paramVarArgs.d(5, this.lJC);
      }
      paramVarArgs.aS(6, this.GDN);
      paramVarArgs.aS(7, this.GFE);
      if (this.GDK != null) {
        paramVarArgs.d(8, this.GDK);
      }
      paramVarArgs.bt(9, this.GFF);
      if (this.GFG != null)
      {
        paramVarArgs.lC(10, this.GFG.computeSize());
        this.GFG.writeFields(paramVarArgs);
      }
      if (this.GFH != null) {
        paramVarArgs.d(11, this.GFH);
      }
      paramVarArgs.e(12, 8, this.GFI);
      paramVarArgs.aS(13, this.GFJ);
      if (this.username != null) {
        paramVarArgs.d(14, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(15, this.path);
      }
      paramVarArgs.bt(16, this.GFK);
      paramVarArgs.bt(17, this.GFL);
      paramVarArgs.aS(18, this.scene);
      AppMethodBeat.o(123587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1374;
      }
    }
    label1374:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.duW);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FKN);
      paramInt = i;
      if (this.lJC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lJC);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GDN) + f.a.a.b.b.a.bz(7, this.GFE);
      paramInt = i;
      if (this.GDK != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GDK);
      }
      i = paramInt + f.a.a.b.b.a.alV(9);
      paramInt = i;
      if (this.GFG != null) {
        paramInt = i + f.a.a.a.lB(10, this.GFG.computeSize());
      }
      i = paramInt;
      if (this.GFH != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GFH);
      }
      i = i + f.a.a.a.c(12, 8, this.GFI) + f.a.a.b.b.a.bz(13, this.GFJ);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.path);
      }
      paramInt = f.a.a.b.b.a.alV(16);
      int j = f.a.a.b.b.a.alV(17);
      int k = f.a.a.b.b.a.bz(18, this.scene);
      AppMethodBeat.o(123587);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        blp localblp = (blp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123587);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 2: 
          localblp.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 3: 
          localblp.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 4: 
          localblp.FKN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 5: 
          localblp.lJC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 6: 
          localblp.GDN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 7: 
          localblp.GFE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 8: 
          localblp.GDK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 9: 
          localblp.GFF = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123587);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblp.GFG = ((chc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 11: 
          localblp.GFH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localblp.GFI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 13: 
          localblp.GFJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 14: 
          localblp.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 15: 
          localblp.path = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 16: 
          localblp.GFK = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123587);
          return 0;
        case 17: 
          localblp.GFL = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123587);
          return 0;
        }
        localblp.scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123587);
        return 0;
      }
      AppMethodBeat.o(123587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blp
 * JD-Core Version:    0.7.0.1
 */