package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String GTG;
  public String Omd;
  public String Ome;
  public int Omf;
  public g Omg;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91743);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Omd != null) {
        paramVarArgs.d(1, this.Omd);
      }
      if (this.Ome != null) {
        paramVarArgs.d(2, this.Ome);
      }
      paramVarArgs.aS(3, this.Omf);
      if (this.GTG != null) {
        paramVarArgs.d(4, this.GTG);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.Omg != null)
      {
        paramVarArgs.lJ(6, this.Omg.computeSize());
        this.Omg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Omd == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.Omd) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ome != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ome);
      }
      i += f.a.a.b.b.a.bz(3, this.Omf);
      paramInt = i;
      if (this.GTG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GTG);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      paramInt = i;
      if (this.Omg != null) {
        paramInt = i + f.a.a.a.lI(6, this.Omg.computeSize());
      }
      AppMethodBeat.o(91743);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91743);
          return -1;
        case 1: 
          locale.Omd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 2: 
          locale.Ome = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 3: 
          locale.Omf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91743);
          return 0;
        case 4: 
          locale.GTG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 5: 
          locale.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91743);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.Omg = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91743);
        return 0;
      }
      AppMethodBeat.o(91743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.e
 * JD-Core Version:    0.7.0.1
 */