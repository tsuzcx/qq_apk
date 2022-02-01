package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmh
  extends cvw
{
  public String GXn;
  public int GXq;
  public int GZg;
  public boolean GZh;
  public chw GZi;
  public String GZj;
  public LinkedList<cca> GZk;
  public int GZl;
  public boolean GZm;
  public boolean GZn;
  public int Gdm;
  public String dwb;
  public String lOc;
  public String path;
  public int scene;
  public int type;
  public String username;
  
  public bmh()
  {
    AppMethodBeat.i(123586);
    this.GZh = false;
    this.GZk = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.type);
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      paramVarArgs.aS(4, this.Gdm);
      if (this.lOc != null) {
        paramVarArgs.d(5, this.lOc);
      }
      paramVarArgs.aS(6, this.GXq);
      paramVarArgs.aS(7, this.GZg);
      if (this.GXn != null) {
        paramVarArgs.d(8, this.GXn);
      }
      paramVarArgs.bC(9, this.GZh);
      if (this.GZi != null)
      {
        paramVarArgs.lJ(10, this.GZi.computeSize());
        this.GZi.writeFields(paramVarArgs);
      }
      if (this.GZj != null) {
        paramVarArgs.d(11, this.GZj);
      }
      paramVarArgs.e(12, 8, this.GZk);
      paramVarArgs.aS(13, this.GZl);
      if (this.username != null) {
        paramVarArgs.d(14, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(15, this.path);
      }
      paramVarArgs.bC(16, this.GZm);
      paramVarArgs.bC(17, this.GZn);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dwb);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Gdm);
      paramInt = i;
      if (this.lOc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lOc);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GXq) + f.a.a.b.b.a.bz(7, this.GZg);
      paramInt = i;
      if (this.GXn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GXn);
      }
      i = paramInt + f.a.a.b.b.a.amF(9);
      paramInt = i;
      if (this.GZi != null) {
        paramInt = i + f.a.a.a.lI(10, this.GZi.computeSize());
      }
      i = paramInt;
      if (this.GZj != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GZj);
      }
      i = i + f.a.a.a.c(12, 8, this.GZk) + f.a.a.b.b.a.bz(13, this.GZl);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.path);
      }
      paramInt = f.a.a.b.b.a.amF(16);
      int j = f.a.a.b.b.a.amF(17);
      int k = f.a.a.b.b.a.bz(18, this.scene);
      AppMethodBeat.o(123587);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GZk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmh localbmh = (bmh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123587);
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
            localbmh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 2: 
          localbmh.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 3: 
          localbmh.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 4: 
          localbmh.Gdm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 5: 
          localbmh.lOc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 6: 
          localbmh.GXq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 7: 
          localbmh.GZg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 8: 
          localbmh.GXn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 9: 
          localbmh.GZh = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123587);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmh.GZi = ((chw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 11: 
          localbmh.GZj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmh.GZk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 13: 
          localbmh.GZl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123587);
          return 0;
        case 14: 
          localbmh.username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 15: 
          localbmh.path = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 16: 
          localbmh.GZm = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123587);
          return 0;
        case 17: 
          localbmh.GZn = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123587);
          return 0;
        }
        localbmh.scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123587);
        return 0;
      }
      AppMethodBeat.o(123587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmh
 * JD-Core Version:    0.7.0.1
 */