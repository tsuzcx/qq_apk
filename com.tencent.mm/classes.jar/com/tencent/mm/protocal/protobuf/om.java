package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class om
  extends com.tencent.mm.bw.a
{
  public int FNv;
  public LinkedList<String> Gcm;
  public int Gcn;
  public String Gcs;
  public String Gct;
  public LinkedList<ol> Gcu;
  public String jfY;
  public String nIJ;
  public String nJO;
  public String usP;
  
  public om()
  {
    AppMethodBeat.i(188938);
    this.Gcu = new LinkedList();
    this.Gcm = new LinkedList();
    AppMethodBeat.o(188938);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNv);
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      if (this.usP != null) {
        paramVarArgs.d(4, this.usP);
      }
      if (this.jfY != null) {
        paramVarArgs.d(5, this.jfY);
      }
      if (this.Gcs != null) {
        paramVarArgs.d(6, this.Gcs);
      }
      if (this.Gct != null) {
        paramVarArgs.d(7, this.Gct);
      }
      paramVarArgs.e(8, 8, this.Gcu);
      paramVarArgs.e(9, 1, this.Gcm);
      paramVarArgs.aS(10, this.Gcn);
      AppMethodBeat.o(188939);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FNv) + 0;
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJO);
      }
      paramInt = i;
      if (this.usP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.usP);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jfY);
      }
      paramInt = i;
      if (this.Gcs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gcs);
      }
      i = paramInt;
      if (this.Gct != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gct);
      }
      paramInt = f.a.a.a.c(8, 8, this.Gcu);
      int j = f.a.a.a.c(9, 1, this.Gcm);
      int k = f.a.a.b.b.a.bz(10, this.Gcn);
      AppMethodBeat.o(188939);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gcu.clear();
      this.Gcm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188939);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      om localom = (om)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(188939);
        return -1;
      case 1: 
        localom.FNv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(188939);
        return 0;
      case 2: 
        localom.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188939);
        return 0;
      case 3: 
        localom.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188939);
        return 0;
      case 4: 
        localom.usP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188939);
        return 0;
      case 5: 
        localom.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188939);
        return 0;
      case 6: 
        localom.Gcs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188939);
        return 0;
      case 7: 
        localom.Gct = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188939);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ol();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localom.Gcu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188939);
        return 0;
      case 9: 
        localom.Gcm.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(188939);
        return 0;
      }
      localom.Gcn = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(188939);
      return 0;
    }
    AppMethodBeat.o(188939);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.om
 * JD-Core Version:    0.7.0.1
 */